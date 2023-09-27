package de.waldheinz.fs.fat;
import de.waldheinz.fs.util.RamDisk;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: waldheinz_fat32-lib###waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest###testSetSize
public 
class ClusterChainTest_testSetSize {
    @Mock
    private Fat fat;
    @Mock
    private RamDisk ramdisk;
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private ClusterChain clusterChain;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(fat.getDevice()).thenReturn(ramdisk);
        when(fat.getBootSector().getFilesOffset()).thenReturn(512L); 
        when(fat.getBootSector().getBytesPerCluster()).thenReturn(4096L); 
        clusterChain = new ClusterChain(fat, false);
    }
    @Test
    public void testSetSizeWithValidInputThrowsNoException() throws Exception {
        assertEquals(4096L, clusterChain.setSize(408));
    }
    @Test
    public void testSetSizeWithInvalidInputThrowsIllegalArgumentException() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("cluster 0 is free");
        doThrow(new IllegalArgumentException("cluster 0 is free").when(fat).testCluster(anyLong());
        clusterChain.setSize(0);
    }
    @Test
    public void testSetSizeWithTooManyClustersThrowsIOException() throws Exception {
        exception.expect(IOException.class);
        exception.expectMessage("too many clusters");
        when(fat.getBootSector().getBytesPerCluster()).thenReturn(Integer.MAX_VALUE+1L);
        clusterChain.setSize(Integer.MAX_VALUE*4097L);
    }
}