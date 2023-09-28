package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.ObjectInfo;
import org.duraspace.fcrepo.cloudsync.api.ObjectStore;
import org.duraspace.fcrepo.cloudsync.service.util.JSON;
import org.duraspace.fcrepo.cloudsync.service.util.StringUtil;
import com.github.cwilper.fcrepo.dto.core.ControlGroup;
import com.github.cwilper.fcrepo.dto.core.Datastream;
import com.github.cwilper.fcrepo.dto.core.DatastreamVersion;
import com.github.cwilper.fcrepo.dto.core.FedoraObject;
import com.github.cwilper.fcrepo.dto.core.io.DateUtil;
import com.github.cwilper.fcrepo.dto.foxml.FOXMLReader;
import com.github.cwilper.fcrepo.dto.foxml.FOXMLWriter;
import com.github.cwilper.fcrepo.httpclient.FedoraHttpClient;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;
import com.github.cwilper.fcrepo.riclient.RIClient;
import com.github.cwilper.fcrepo.riclient.RIQueryResult;
import com.github.cwilper.ttff.Filter;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.openrdf.model.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class FedoraConnector extends StoreConnector {
    
    private static final Logger logger = 
            LoggerFactory.getLogger(FedoraConnector.class);

    private final FedoraHttpClient httpClient;
    private final RIClient riClient;

    public FedoraConnector(ObjectStore store, HttpClientConfig httpClientConfig) {
        Map<String, String> map = JSON.getMap(JSON.parse(store.getData()));
        String url = StringUtil.validate("url", map.get("url"));
        String username = StringUtil.validate("username", map.get("username"));
        String password = StringUtil.validate("password", map.get("password"));
        httpClient = new FedoraHttpClient(httpClientConfig,
                URI.create(url), username, password);
        setPreemptiveAuth(httpClient);
        riClient = new RIClient(httpClient);
    }

    @Override
    public void listObjects(ObjectQuery query, ObjectListHandler handler) {
        String type = query.getType();
        if (type.equals("pidPattern")) {
            RIQueryResult result = riClient.itql("select $o from <#ri> where $o <fedora-model:hasModel> <info:fedora/fedora-system:FedoraObject-3.0>", false);
            listObjects(result, new PIDPatternFilter(query.getPidPattern()), handler);
        } else if (type.equals("pidList")) {
            listObjects(query.getPidList().iterator(), handler);
        } else if (type.equals("query")) {
            RIQueryResult result;
            if (query.getQueryType().equals("iTQL")) {
                result = riClient.itql(query.getQueryText(), false);
            } else if (query.getQueryType().equals("SPARQL")) {
                result = riClient.sparql(query.getQueryText(), false);
            } else {
                throw new IllegalArgumentException("Query type '" + query.getQueryType() + "' unrecognized.");
            }
            listObjects(result, null, handler);
        }
    }

    @Override
    protected boolean hasObject(String pid) {
        return headCheck(httpClient, getObjectURI(pid));
    }

    @Override
    public FedoraObject getObject(String pid) {
        InputStream in = getStream(httpClient, getObjectURI(pid) + "/export?context=migrate");
        if (in == null) return null;
        try {
            return new FOXMLReader().readObject(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean putObject(FedoraObject o, 
                             StoreConnector source,
                             boolean overwrite,
                             boolean copyExternal,
                             boolean copyRedirect) {
        boolean existed = hasObject(o.pid());
        if (existed) {
            if (overwrite) {
                delete(httpClient, getObjectURI(o.pid()));
            } else {
                return existed;
            }
        }
        FOXMLWriter writer = new FOXMLWriter();
        File tempFile = null;
        OutputStream out = null;
        try {
            // stage any managed datastream content, changing refs as needed
            stageManagedContent(o, source);
            // stage and convert E/R datastreams to managed, if needed
            stageAndConvertERDatastreams(o, source, copyExternal, copyRedirect);
            // write foxml to temp file
            tempFile = File.createTempFile("cloudsync", null);
            out = new FileOutputStream(tempFile);
            writer.writeObject(o, out);
            out.close();
            // ingest object into Fedora
            post(httpClient, getObjectURI(o.pid()), tempFile, "text/xml");
            return existed;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(out);
            if (tempFile != null) {
                tempFile.delete();
            }
            writer.close();
        }
    }
    
    private void stageAndConvertERDatastreams(FedoraObject o,
            StoreConnector source, boolean copyExternal, boolean copyRedirect)
            throws IOException {
        for (Datastream ds: o.datastreams().values()) {
            ControlGroup g = ds.controlGroup();
            if ((g.equals(ControlGroup.EXTERNAL) && copyExternal)
                    || (g.equals(ControlGroup.REDIRECT) && copyRedirect)) {
                stageVersions(o, ds, source);
                ds.controlGroup(ControlGroup.MANAGED);
            }
        }
    }
    
    private void stageManagedContent(FedoraObject o,
                                     StoreConnector source) throws IOException {
        for (Datastream ds: o.datastreams().values()) {
            if (ds.controlGroup().equals(ControlGroup.MANAGED)) {
                stageVersions(o, ds, source);
            }
        }
    }
    
    private void stageVersions(FedoraObject o,
                               Datastream ds,
                               StoreConnector source) throws IOException {
        for (DatastreamVersion dsv: ds.versions()) {
            InputStream in = source.getContent(o,  ds, dsv);
            File tempFile = File.createTempFile("cloudsync", null);
            OutputStream out = new FileOutputStream(tempFile);
            try {
                // copy content to local temporary file first
                try {
                    IOUtils.copyLarge(in,  out);
                } finally {
                    IOUtils.closeQuietly(in);
                    IOUtils.closeQuietly(out);
                }
                // upload and set content location accordingly
                dsv.contentLocation(upload(tempFile));
            } finally {
                // finally, delete the local copy
                if (!tempFile.delete()) {
                    logger.warn("Failed to delete temporary file {}", tempFile);
                }
            }
        }
    }    
   
    private URI upload(File file) throws IOException {
        String url = httpClient.getBaseURI() + "/upload";
        logger.debug("Doing Multipart POST on " + url);
        HttpPost post = new HttpPost(url);
        String body = null;
        try {
            FileBody fileBody = new FileBody(file);
            MultipartEntity reqEntity =
                    new MultipartEntity(HttpMultipartMode.STRICT);
            reqEntity.addPart("file", fileBody);
            post.setEntity(reqEntity);
            HttpResponse response = httpClient.execute(post);
            HttpEntity resEntity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 202) {
                throw new RuntimeException("Unexpected response code (" + responseCode + ") posting " + url);
            }
            body = EntityUtils.toString(resEntity, "UTF-8");
            return new URI(body);
        } catch (URISyntaxException e) {
            throw new IOException("Error staging datastream content; "
                    + "response to /upload request was not a URI: " + body);
        }
    }

    private String getObjectURI(String pid) {
        return httpClient.getBaseURI() + "/objects/" + pid;
    }

    @Override
    public InputStream getContent(FedoraObject o, Datastream ds, DatastreamVersion dsv) {
        String url = getObjectURI(o.pid()) + "/datastreams/" + ds.id()
                + "/content?asOfDateTime=" 
                + DateUtil.toString(dsv.createdDate());
        return getStream(httpClient, url);
    }

    @Override
    public void close() {
        httpClient.close();
    }

    private void listObjects(RIQueryResult result, Filter<String> filter, ObjectListHandler handler) {
        try {
            boolean keepGoing = true;
            while (result.hasNext() && keepGoing) {
                List<Value> row = result.next();
                // info:fedora/ = 12
                String pid = row.get(0).toString().substring(12);
                if (filter == null || filter.accept(pid) != null) {
                    ObjectInfo o = new ObjectInfo();
                    o.setPid(pid);
                    keepGoing = handler.handleObject(o);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error iterating query results", e);
        } finally {
            result.close();
        }
    }

    // http://stackoverflow.com/questions/2014700/preemptive-basic-authentication-with-apache-httpclient-4
    private void setPreemptiveAuth(FedoraHttpClient httpClient) {
        this.localContext = new BasicHttpContext();
        BasicScheme basicAuth = new BasicScheme();
        localContext.setAttribute("preemptive-auth", basicAuth);
        httpClient.addRequestInterceptor(new PreemptiveAuthInterceptor(), 0);
    }

    static class PreemptiveAuthInterceptor implements HttpRequestInterceptor {

        public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
            AuthState authState = (AuthState) context.getAttribute(ClientContext.TARGET_AUTH_STATE);

            // If no auth scheme avaialble yet, try to initialize it
            // preemptively
            if (authState.getAuthScheme() == null) {
                AuthScheme authScheme = (AuthScheme) context.getAttribute("preemptive-auth");
                CredentialsProvider credsProvider = (CredentialsProvider) context.getAttribute(ClientContext.CREDS_PROVIDER);
                HttpHost targetHost = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                if (authScheme != null) {
                    Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()));
                    if (creds == null) {
                        throw new HttpException("No credentials for preemptive authentication");
                    }
                    authState.setAuthScheme(authScheme);
                    authState.setCredentials(creds);
                }
            }

        }

}

}
