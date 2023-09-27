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
    RamDisk ramDisk = new RamDisk(1024 * 1024);
    Fat fat = new Fat(ramDisk);
    ClusterChain chain = new ClusterChain(fat, true);
    ByteBuffer buffer = ByteBuffer.allocateDirect(512);
    buffer.putInt(0xDEADBEEF).putShort((short) 0xCAFE).putLong(0xBABEBABEL);
    buffer.rewind();
    assertEquals(buffer.capacity(), chain.setSize(buffer.capacity()));
    try {
        chain.setSize(buffer.capacity() + 1);
        fail("Expected exception when trying to set size beyond capacity");
    } catch (IllegalStateException e) {
    }
    try {
        chain.setSize(-1L);
        fail("Expected exception when trying to set size to negative value");
    } catch (IllegalArgumentException e) {
    }
    fat.close();
    ramDisk.dispose();
}
}