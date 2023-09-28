package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.ObjectInfo;
import org.duraspace.fcrepo.cloudsync.api.ObjectStore;
import com.github.cwilper.fcrepo.dto.core.Datastream;
import com.github.cwilper.fcrepo.dto.core.DatastreamVersion;
import com.github.cwilper.fcrepo.dto.core.FedoraObject;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.FileEntity;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public abstract class StoreConnector {

    private static final Logger logger = LoggerFactory.getLogger(StoreConnector.class);
    
    protected BasicHttpContext localContext = null;

    public static StoreConnector getInstance(ObjectStore store, HttpClientConfig httpClientConfig) {
        if (store.getType().equals("fedora")) {
            return new FedoraConnector(store, httpClientConfig);
        } else if (store.getType().equals("duracloud")) {
            return new DuraCloudConnector(store, httpClientConfig);
        } else if (store.getType().equals("filesystem")) {
            return new FilesystemConnector(store);
        } else {
            throw new IllegalArgumentException("Unrecognized ObjectStore type: " + store.getType());
        }
    }

    protected void listObjects(Iterator<String> pidIterator,
                               ObjectListHandler handler) {
        boolean keepGoing = true;
        while (pidIterator.hasNext() && keepGoing) {
            String pid = pidIterator.next();
            if (hasObject(pid)) {
                ObjectInfo o = new ObjectInfo();
                o.setPid(pid);
                keepGoing = handler.handleObject(o);
            }
        }
    }

    protected boolean headCheck(HttpClient httpClient, String url) {
        logger.debug("Doing HEAD request on " + url);
        HttpHead head = new HttpHead(url);
        try {
            HttpResponse response = execute(httpClient, head);
            int responseCode = response.getStatusLine().getStatusCode();
            logger.debug("responseCode: " + responseCode);
            return responseCode == 200;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // returns null if 404
    protected String getString(HttpClient httpClient, String url) {
        try {
            HttpEntity entity = get(httpClient, url);
            if (entity == null) return null;
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // returns null if 404
    protected InputStream getStream(HttpClient httpClient, String url) {
        try {
            HttpEntity entity = get(httpClient, url);
            if (entity == null) return null;
            return entity.getContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // returns null if 404
    protected HttpEntity get(HttpClient httpClient, String url) throws IOException {
        logger.debug("Doing GET request on " + url);
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = execute(httpClient, get);
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == 404) {
                return null;
            } else if (responseCode != 200) {
                throw new RuntimeException("Unexpected response code (" + responseCode + ") getting " + url);
            }
            return response.getEntity();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void delete(HttpClient httpClient, String url) {
        logger.debug("Doing DELETE request on " + url);
        HttpDelete delete = new HttpDelete(url);
        HttpEntity entity = null;
        try {
            HttpResponse response = execute(httpClient, delete);
            entity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200 && responseCode != 204) {
                throw new RuntimeException("Unexpected response code (" + responseCode + ") deleting " + url);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (Exception e) {
                }
            }
        }
    }

    protected void post(HttpClient httpClient, String url, File file, String mimeType) {
        logger.debug("Doing POST request on " + url);
        HttpPost post = new HttpPost(url);
        HttpEntity entity = null;
        try {
            post.setHeader("Content-type", mimeType);
            post.setEntity(new FileEntity(file, mimeType));
            HttpResponse response = execute(httpClient, post);
            entity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 204) {
                throw new RuntimeException("Unexpected response code (" + responseCode + ") posting " + url);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (Exception e) {
                }
            }
        }
    }

    protected void put(HttpClient httpClient, String url, File file, String mimeType, String md5) {
        logger.debug("Doing PUT request on {} (md5: {})", url, md5);
        HttpPut put = new HttpPut(url);
        HttpEntity entity = null;
        try {
            if (mimeType == null || mimeType.trim().length() == 0) {
                mimeType = "application/octet-stream";
            }
            put.setHeader("Content-Type", mimeType);
            put.setHeader("Content-MD5", md5);
            put.setEntity(new FileEntity(file, mimeType));
            HttpResponse response = execute(httpClient, put);
            entity = response.getEntity();
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200 && responseCode != 201 && responseCode != 204) {
                throw new RuntimeException("Unexpected response code (" + responseCode + ") putting " + url);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (Exception e) {
                }
            }
        }
    }

    // executes a request with the localContext, if set
    private HttpResponse execute(HttpClient client, HttpUriRequest request) throws IOException {
        if (localContext != null) {
            return client.execute(request, localContext);
        } else {
            return client.execute(request);
        }
    }

    public abstract void listObjects(ObjectQuery query,
                                     ObjectListHandler handler);

    protected abstract boolean hasObject(String pid);

    // return null if object doesn't exist
    public abstract FedoraObject getObject(String pid);

    // true if the object previously existed
    public abstract boolean putObject(FedoraObject o,
                                      StoreConnector source,
                                      boolean overwrite,
                                      boolean copyExternal,
                                      boolean copyRedirect);

    public abstract InputStream getContent(FedoraObject o,
                                           Datastream ds,
                                           DatastreamVersion dsv);

    public abstract void close();

}
