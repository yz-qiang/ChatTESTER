package org.duraspace.fcrepo.cloudsync.service.backend;
// original test path: duraspace_fcrepo-cloudsync###duraspace_fcrepo-cloudsync/fcrepo-cloudsync-service/src/test/java/org/duraspace/fcrepo/cloudsync/service/backend/DuraCloudConnectorTest###testPutObject
import com.github.cwilper.fcrepo.dto.core.ControlGroup;
import com.github.cwilper.fcrepo.dto.core.Datastream;
import com.github.cwilper.fcrepo.dto.core.DatastreamVersion;
import com.github.cwilper.fcrepo.dto.core.FedoraObject;
import com.github.cwilper.fcrepo.httpclient.MultiThreadedHttpClient;
import junit.framework.Assert;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.AutoCloseInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.Date;
import java.util.Random;
@RunWith(PowerMockRunner.class)
@PrepareForTest({DuraCloudConnector.class, HttpPut.class, HttpHead.class})
public class DuraCloudConnectorTest_testPutObject {
    private static final String PROVIDER_ID = "testProviderId";
    private static final String PREFIX = "testPrefix";
    private static final String USERNAME = "testUsername";
    private static final String PASSWORD = "testPassword";
    private static final String SPACE = "testSpace";
    private static final String URL = "http:
    private static final String PID = "testPid";
    private static final String CONTENT = "testContent";
    private static final long CHUNK_SIZE = 1024L;
    private DuraCloudConnector connector;
    private MultiThreadedHttpClient httpClient;
    private StoreConnector source;
    private FedoraObject object;
    @BeforeClass
    public static void setUpClass() {
    }
    @Before
    public void setUp() {
        httpClient = PowerMock.createMock(MultiThreadedHttpClient.class);
        source = PowerMock.createMock(StoreConnector.class);
        object = createTestObject();
        connector = new DuraCloudConnector(createTestSpaceURI(), PROVIDER_ID, PREFIX, httpClient, CHUNK_SIZE);
    }
    @After
    public void tearDown() {
    }
    @Test
    public void testPutObject() throws Exception {
        HttpHead headRequest = PowerMock.createMock(HttpHead.class);
        HttpResponse headResponse = PowerMock.createMock(HttpResponse.class);
        StatusLine headStatusLine = PowerMock.createMock(StatusLine.class);
        HttpPut putRequest = PowerMock.createMock(HttpPut.class);
        HttpResponse putResponse = PowerMock.createMock(HttpResponse.class);
        StatusLine putStatusLine = PowerMock.createMock(StatusLine.class);
        PowerMock.expectNew(HttpHead.class, createTestObjectURI()).andReturn(headRequest);
        EasyMock.expect(httpClient.execute(headRequest)).andReturn(headResponse);
        EasyMock.expect(headResponse.getStatusLine()).andReturn(headStatusLine);
        EasyMock.expect(headStatusLine.getStatusCode()).andReturn(404);
        PowerMock.expectNew(HttpPut.class, createTestObjectURI()).andReturn(putRequest);
        putRequest.setHeader("Content-MD5", createTestContentMD5());
        putRequest.setHeader("x-dura-meta-provider-id", PROVIDER_ID);
        putRequest.setHeader("x-dura-meta-prefix", PREFIX);
        putRequest.setHeader("x-dura-meta-pid", PID);
        putRequest.setHeader("x-dura-meta-created", createTestCreatedDate());
        putRequest.setHeader("x-dura-meta-modified", createTestModifiedDate());
        putRequest.setHeader("x-dura-meta-state", "A");
        putRequest.setHeader("x-dura-meta-size", String.valueOf(createTestContentSize()));
        putRequest.setHeader("x-dura-meta-mimetype", "application/xml");
        putRequest.setHeader("x-dura-meta-filename", "test.xml");
        putRequest.setHeader("x-dura-meta-dc-title", "Test Object");
        putRequest.setHeader("x-dura-meta-dc-creator", "Test Creator");
        putRequest.setHeader("x-dura-meta-dc-subject", "Test Subject");
        putRequest.setHeader("x-dura-meta-dc-description", "Test Description");
        putRequest.setHeader("x-dura-meta-dc-publisher", "Test Publisher");
        putRequest.setHeader("x-dura-meta-dc-contributor", "Test Contributor");
        putRequest.setHeader("x-dura-meta-dc-date", "Test Date");
        putRequest.setHeader("x-dura-meta-dc-type", "Test Type");
        putRequest.setHeader("x-dura-meta-dc-format", "Test Format");
        putRequest.setHeader("x-dura-meta-dc-identifier", "Test Identifier");
        putRequest.setHeader("x-dura-meta-dc-source", "Test Source");
        putRequest.setHeader("x-dura-meta-dc-language", "Test Language");
        putRequest.setHeader("x-dura-meta-dc-relation", "Test Relation");
        putRequest.setHeader("x-dura-meta-dc-coverage", "Test Coverage");
        putRequest.setHeader("x-dura-meta-dc-rights", "Test Rights");
        putRequest.setEntity(new ByteArrayEntity(CONTENT.getBytes()));
        EasyMock.expect(httpClient.execute(putRequest)).andReturn(putResponse);
        EasyMock.expect(putResponse.getStatusLine()).andReturn(putStatusLine);
        EasyMock.expect(putStatusLine.getStatusCode()).andReturn(201);
        PowerMock.replayAll();
        EasyMock.replay(httpClient, source);
        boolean result = connector.putObject(object, source, true, true, true);
        PowerMock.verifyAll();
        EasyMock.verify(httpClient, source);
        Assert.assertTrue(result);
    }
    private URI createTestSpaceURI() {
        return URI.create(URL + "/" + SPACE);
    }
    private URI createTestObjectURI() {
        return URI.create(URL + "/" + SPACE + "/" + PID);
    }
    private FedoraObject createTestObject() {
        FedoraObject object = new FedoraObject();
        object.pid(PID);
        object.created(createTestCreatedDate());
        object.modified(createTestModifiedDate());
        object.state("A");
        object.label("Test Object");
        object.ownerId("testOwner");
        object.datastreams().put("testDatastream", createTestDatastream());
        object.properties().put("testProperty", "testValue");
        return object;
    }
    private Datastream createTestDatastream() {
        Datastream datastream = new Datastream();
        datastream.id("testDatastream");
        datastream.label("Test Datastream");
        datastream.mimeType("application/xml");
        datastream.formatURI("http:
        datastream.versionable(true);
        datastream.versions().put("1", createTestDatastreamVersion());
        return datastream;
    }
    private DatastreamVersion createTestDatastreamVersion() {
        DatastreamVersion version = new DatastreamVersion();
        version.id("1");
        version.label("Test Datastream Version");
        version.created(createTestCreatedDate());
        version.modified(createTestModifiedDate());
        version.state("A");
        version.formatURI("http:
        version.mimeType("application/xml");
        version.size(createTestContentSize());
        version.checksumType("MD5");
        version.checksum(createTestContentMD5());
        version.content(createTestContent());
        return version;
    }
    private String createTestCreatedDate() {
        return "2019-01-01T00:00:00.000Z";
    }
    private String createTestModifiedDate() {
        return "2019-01-02T00:00:00.000Z";
    }
    private long createTestContentSize() {
        return CONTENT.length();
    }
    private String createTestContentMD5() {
        return "testContentMD5";
    }
    private ByteArrayInputStream createTestContent() {
        return new ByteArrayInputStream(CONTENT.getBytes());
    }
}