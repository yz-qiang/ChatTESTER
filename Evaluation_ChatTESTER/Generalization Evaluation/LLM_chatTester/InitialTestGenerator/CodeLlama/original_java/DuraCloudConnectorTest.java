package org.duraspace.fcrepo.cloudsync.service.backend;

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

/**
 * @author Andrew Woods
 *         Date: 10/14/12
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MultiThreadedHttpClient.class)
public class DuraCloudConnectorTest {

    private DuraCloudConnector connector;

    private URI spaceURI;
    private final String providerId = "2";
    private String prefix = null;
    private MultiThreadedHttpClient httpClient;

    private StoreConnector source;

    private HttpResponse response;

    private static int numDatastreams = 4;
    private static long contentChunkSize = 1024;
    private static String text;

    @BeforeClass
    public static void beforeClass() throws Exception {
        text = getContentText(contentChunkSize * 2 + 100);
    }

    private static String getContentText(long numChars) throws Exception {
        final int BUF_SZ = 8192;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, BUF_SZ);

        int MIN_CHAR = 32;
        int MAX_CHAR_MINUS_MIN_CHAR = 126 - MIN_CHAR;
        Random r = new Random();
        for (long i = 0; i < numChars; ++i) {
            bw.write(r.nextInt(MAX_CHAR_MINUS_MIN_CHAR) + MIN_CHAR);
        }
        IOUtils.closeQuietly(bw);

        return bos.toString();
    }

    @Before
    public void setUp() throws Exception {
        spaceURI = new URI("http://duracloud.org/space/id");
        httpClient = PowerMock.createMock(MultiThreadedHttpClient.class);

        source = EasyMock.createMock("StoreConnector", StoreConnector.class);
        response = EasyMock.createMock("HttpResponse", HttpResponse.class);


        connector = new DuraCloudConnector(spaceURI,
                                           providerId,
                                           prefix,
                                           httpClient,
                                           contentChunkSize);
    }

    private void replayMocks() {
        PowerMock.replay(httpClient, source, response);
    }

    @After
    public void tearDown() throws Exception {
        PowerMock.verify(httpClient, source, response);
    }

    @Test
    public void testListObjects() throws Exception {
        replayMocks();
        // TODO: implement
    }

    @Test
    public void testGetObject() throws Exception {
        replayMocks();
        // TODO: implement
    }

    @Test
    public void testPutObject() throws Exception {
        createMocksPutObject();
        replayMocks();

        FedoraObject obj = createFedoraObject();
        boolean overwrite = true;
        boolean copyExternal = true;
        boolean copyRedirect = true;

        boolean existed = connector.putObject(obj,
                                              source,
                                              overwrite,
                                              copyExternal,
                                              copyRedirect);

        Assert.assertTrue(existed);
    }

    private FedoraObject createFedoraObject() {
        FedoraObject obj = new FedoraObject();
        obj.pid("pid-x");

        for (int i = 0; i < numDatastreams; ++i) {
            Datastream ds = new Datastream("ds-" + i);
            ds.controlGroup(ControlGroup.EXTERNAL);
            ds.addVersion(new Date());

            obj.putDatastream(ds);
        }

        return obj;
    }

    private void createMocksPutObject() throws Exception {
        int numHeads = 1;
        int numChunksPerDatastream = 4;
        int numPuts = 1 + (numDatastreams * numChunksPerDatastream);
        int numResponses = numHeads + numPuts;

        StatusLine statusLine = EasyMock.createMock("StatusLine",
                                                    StatusLine.class);
        EasyMock.expect(statusLine.getStatusCode()).andReturn(200).times(
            numResponses);
        EasyMock.replay(statusLine);

        EasyMock.expect(response.getStatusLine()).andReturn(statusLine).times(
            numResponses);

        EasyMock.expect(httpClient.execute(EasyMock.isA(HttpHead.class)))
                .andReturn(response);

        EasyMock.expect(response.getEntity()).andReturn(null).times(numPuts);

        EasyMock.expect(httpClient.execute(EasyMock.isA(HttpPut.class)))
                .andReturn(response)
                .times(numPuts);

        for (int i = 0; i < numDatastreams; ++i) {
            EasyMock.expect(source.getContent(EasyMock.isA(FedoraObject.class),
                                              EasyMock.isA(Datastream.class),
                                              EasyMock.isA(DatastreamVersion.class)))
                    .andReturn(new AutoCloseInputStream(new ByteArrayInputStream(
                        text.getBytes())));
        }
    }

    @Test
    public void testGetContent() throws Exception {
        replayMocks();
        // TODO: implement
    }

    @Test
    public void testGetStream() throws Exception {
        replayMocks();
        // TODO: implement
    }

    @Test
    public void testClose() throws Exception {
        replayMocks();
        // TODO: implement
    }
}
