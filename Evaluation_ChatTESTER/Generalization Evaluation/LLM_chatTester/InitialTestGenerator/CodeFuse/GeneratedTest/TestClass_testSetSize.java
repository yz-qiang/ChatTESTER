package de.waldheinz.fs.fat;
import de.waldheinz.fs.util.RamDisk;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
// original test path: waldheinz_fat32-lib###waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest###testSetSize
public 
class TestClass_testSetSize {
    private RamDisk ramdisk;
    private FileSystem fs;
    private Fat fat;
    private ClusterChain cc;
    @Before
    public void setup() throws Exception{
         ramdisk = new RamDisk();
         fs = new FileSystem(ramdisk);
         fat = new Fat(fs);
         cc = new ClusterChain(fat, false);
    }
    @Test
    public void testSetSize() throws IOException {
        String fileName = "/path/to/your/file";
        byte[] data = "Hello World!".getBytes();
        Files.write(Paths.get(fileName), ByteBuffer.wrap(data));
        SeekableByteChannel channel = Files.newByteChannel(Paths.get(fileName), StandardOpenOption.READ);
        long expectedSize = data.length;
        long actualSize = cc.setSize(expectedSize);
        assertEquals(expectedSize, actualSize);
    }
}