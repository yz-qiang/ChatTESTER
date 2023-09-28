package org.duraspace.fcrepo.cloudsync.service.backend.chunk;

import junit.framework.Assert;
import org.apache.commons.io.input.AutoCloseInputStream;
import org.duraspace.fcrepo.cloudsync.service.backend.DuraCloudConnector;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrew Woods
 *         Date: 10/14/12
 */
public class MultiChunkInputStreamTest {

    private MultiChunkInputStream stream;

    private DuraCloudConnector connector;
    private List<String> chunks;

    @Before
    public void setUp() throws Exception {
        connector = EasyMock.createMock("DuraCloudConnector",
                                        DuraCloudConnector.class);
        chunks = new ArrayList<String>();
        chunks.add("chunk0");
        chunks.add("chunk1");
        chunks.add("chunk2");
        chunks.add("chunk3");
        chunks.add("chunk4");

        stream = new MultiChunkInputStream(connector, chunks);
    }

    @After
    public void tearDown() throws Exception {
        EasyMock.verify(connector);
    }

    private void replayMocks() {
        EasyMock.replay(connector);
    }

    @Test
    public void testRead() throws Exception {
        createConnectorMock();
        replayMocks();

        int bite;
        StringBuilder text = new StringBuilder();
        while ((bite = stream.read()) != -1) {
            text.append(Character.toChars(bite));
        }

        // Verify all bytes were read
        StringBuilder expected = new StringBuilder();
        for (String chunk : chunks) {
            expected.append(chunk);
        }
        Assert.assertEquals(expected.toString(), text.toString());
    }

    private void createConnectorMock() {
        for (String chunk : chunks) {
            EasyMock.expect(connector.getStream(chunk))
                    .andReturn(new AutoCloseInputStream(new ByteArrayInputStream(
                        chunk.getBytes())));
        }
    }

}
