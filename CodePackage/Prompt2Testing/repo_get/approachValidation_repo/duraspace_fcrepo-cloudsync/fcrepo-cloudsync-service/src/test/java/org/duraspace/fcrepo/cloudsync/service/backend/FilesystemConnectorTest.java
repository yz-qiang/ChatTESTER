package org.duraspace.fcrepo.cloudsync.service.backend;

import org.duraspace.fcrepo.cloudsync.api.ObjectStore;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class FilesystemConnectorTest {
    
    File tempDir;
    
    @Before
    public void setUp() throws IOException {
        tempDir = File.createTempFile("test", null);
        tempDir.delete();
        tempDir.mkdir();
    }

    @After
    public void tearDown() {
        delete(tempDir);
    }
    
    private static void delete(File f) {
        if (f.isDirectory()) {
            for (File child : f.listFiles()) {
                delete(child);
            }
        }
        f.delete();
    }

    @Test (expected=IllegalArgumentException.class)
    public void emptyPath() {
        FilesystemConnector c = getInstance("");
    }

    @Test (expected=IllegalArgumentException.class)
    public void noSuchParentDir() {
        FilesystemConnector c = getInstance("/tmp/nonExistingDir/foo");
    }

    @Test
    public void baseDirExists() {
        FilesystemConnector c = getInstance(tempDir.getPath());
    }

    @Test
    public void parentDirExists() {
        FilesystemConnector c = getInstance(tempDir.getPath() + "/childDir");
    }

    @Test
    public void encodePid() {
        String result = FilesystemConnector.encode("demo:1", null, null);
        Assert.assertEquals("demo%3A1", result);
    }

    @Test
    public void encodeDatastream() {
        String result = FilesystemConnector.encode("demo:1", "DC", "DC.0");
        Assert.assertEquals("demo%3A1+DC+DC.0", result);
    }

    @Test
    public void decodePid() {
        String[] result = FilesystemConnector.decode("demo%3A1");
        Assert.assertEquals("demo:1", result[0]);
        Assert.assertNull(result[1]);
        Assert.assertNull(result[2]);
    }

    @Test
    public void decodeDatastream() {
        String[] result = FilesystemConnector.decode("demo%3A1+DC+DC.0");
        Assert.assertEquals("demo:1", result[0]);
        Assert.assertEquals("DC", result[1]);
        Assert.assertEquals("DC.0", result[2]);
    }
    
    @Test
    public void getPath() {
        Assert.assertEquals("d9/59", FilesystemConnector.getPath("demo:1"));
        Assert.assertEquals("5b/57", FilesystemConnector.getPath("demo:2"));
    }
    
    private static FilesystemConnector getInstance(String path) {
        ObjectStore config = new ObjectStore();
        config.setId("0");
        config.setType("filesystem");
        config.setName("foo");
        config.setUri(URI.create("http://example.org/cloudsync/api/rest/stores/0"));
        config.setData("{ \"path\": \"" + path + "\" }");
        return new FilesystemConnector(config);
    }
    
}
