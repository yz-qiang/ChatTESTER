package de.waldheinz.fs.fat;
import de.waldheinz.fs.util.RamDisk;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: waldheinz_fat32-lib###waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest###testSetSize
public class TTT_testSetSize {
@Test
public void testSetSize() throws Exception {
    Fat fat = Mockito.mock(Fat.class);
    when(fat.getBootSector()).thenReturn(new BootSector());
    when(fat.getDevice()).thenReturn(Mockito.mock(BlockDevice.class));
    when(fat.getBootSector().getFilesOffset()).thenReturn(0L);
    when(fat.getBootSector().getBytesPerCluster()).thenReturn(512L);
    ClusterChain chain = new ClusterChain(fat, true);
    assertEquals(0, chain.getChainLength());
    long expectedSize = 4096L;
    long actualSize = chain.setSize(expectedSize);
    assertEquals(expectedSize, actualSize);
    assertEquals(8, chain.getChainLength());
    try {
        chain.setSize(-1L);
        fail("Expected exception was not thrown");
    } catch (IllegalArgumentException e) {
        assertTrue(e.getMessage(), e.getMessage().contains("negative"));
    }
    try {
        chain.setSize(Integer.MAX_VALUE + 1L);
        fail("Expected exception was not thrown");
    } catch (IOException e) {
        assertTrue(e.getMessage(), e.getMessage().contains("too many clusters"));
    }
}
}