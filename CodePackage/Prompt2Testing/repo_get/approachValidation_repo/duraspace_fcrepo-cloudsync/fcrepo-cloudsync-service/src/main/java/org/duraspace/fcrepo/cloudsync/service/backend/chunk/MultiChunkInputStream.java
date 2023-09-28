/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 *     http://duracloud.org/license/
 */
package org.duraspace.fcrepo.cloudsync.service.backend.chunk;

import org.duraspace.fcrepo.cloudsync.service.backend.DuraCloudConnector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author Andrew Woods
 *         Date: 10/14/12
 */
public class MultiChunkInputStream extends InputStream {

    private DuraCloudConnector store;
    private Iterator<String> chunkIds;
    private InputStream currentStream;

    public MultiChunkInputStream(DuraCloudConnector store,
                                 List<String> chunks) {
        this.store = store;
        this.chunkIds = chunks.iterator();
        this.currentStream = null;
    }

    @Override
    public int read() throws IOException {
        // initialize current stream
        if (null == currentStream) {
            if (chunkIds.hasNext()) {
                currentStream = nextStream();

            } else {
                return -1;
            }
        }

        int bite = currentStream.read();
        if (-1 == bite && chunkIds.hasNext()) {
            currentStream = nextStream();
            bite = currentStream.read();
        }

        return bite;
    }

    private InputStream nextStream() {
        return getStream(chunkIds.next());
    }

    private InputStream getStream(String chunkId) {
        return store.getStream(chunkId);
    }
}
