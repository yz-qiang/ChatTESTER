package org.duraspace.fcrepo.cloudsync.service.dao;

import org.duraspace.fcrepo.cloudsync.api.ProviderAccount;
import org.duraspace.fcrepo.cloudsync.api.Space;
import com.github.cwilper.fcrepo.httpclient.HttpClientConfig;
import com.github.cwilper.fcrepo.httpclient.MultiThreadedHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DuraCloudDao {

    private final MultiThreadedHttpClient httpClient;

    public DuraCloudDao() {
        HttpClientConfig config = new HttpClientConfig();
        config.setPreemptiveAuthN(true);
        config.setSkipSSLHostnameVerification(true);
        config.setSkipSSLTrustCheck(true);
        httpClient = new MultiThreadedHttpClient(config);
    }

    public List<ProviderAccount> listProviderAccounts(String url,
                                               String username,
                                               String password) {
        List<ProviderAccount> list = new ArrayList<ProviderAccount>();
        String response = null;
        try {
            response = get(url + "/stores", username, password);
            Document doc = parseXML(response);
            Node root = doc.getDocumentElement();
            NodeList accountNodes = root.getChildNodes();
            for (int i = 0; i < accountNodes.getLength(); i++) {
                Node accountNode = accountNodes.item(i);
                if (accountNode.getNodeType() == Node.ELEMENT_NODE) {
                    ProviderAccount p = new ProviderAccount();
                    Node isPrimaryNode = accountNode.getAttributes().getNamedItem("isPrimary");
                    if (isPrimaryNode != null && isPrimaryNode.getNodeValue().equals("1")) {
                        p.setPrimary(true);
                    }
                    NodeList childNodes = accountNode.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode.getNodeName().equals("storageProviderType")) {
                            p.setType(childNode.getTextContent());
                        } else if (childNode.getNodeName().equals("id")) {
                            p.setId(childNode.getTextContent());
                        }
                    }
                    list.add(p);
                }
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing response: " + response,
                                       e);
        }
    }

    public List<Space> listSpaces(String url,
                                  String username,
                                  String password,
                                  String providerAccountId) {
        List<Space> list = new ArrayList<Space>();
        String response = null;
        try {
            response = get(url + "/spaces?storeID=" + providerAccountId,
                           username, password);
            Document doc = parseXML(response);
            Node root = doc.getDocumentElement();
            NodeList spaceNodes = root.getChildNodes();
            for (int i = 0; i < spaceNodes.getLength(); i++) {
                Node spaceNode = spaceNodes.item(i);
                Node idNode = spaceNode.getAttributes().getNamedItem("id");
                Space space = new Space();
                space.setId(idNode.getNodeValue());
                list.add(space);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing response: " + response,
                                       e);
        }
    }

    private String get(String url, String username, String password)
            throws MalformedURLException, IOException {
        URL u = new URL(url);
        int port = u.getPort();
        if (port == -1) {
            port = u.getDefaultPort();
        }
        httpClient.getCredentialsProvider().setCredentials(
                new AuthScope(u.getHost(), port),
                new UsernamePasswordCredentials(username, password)
        );
        HttpResponse response = httpClient.execute(new HttpGet(url));
        return EntityUtils.toString(response.getEntity());
    }

    private Document parseXML(String xmlString)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        InputSource inStream = new InputSource();
        inStream.setCharacterStream(new StringReader(xmlString));
        return db.parse(inStream);
    }

}
