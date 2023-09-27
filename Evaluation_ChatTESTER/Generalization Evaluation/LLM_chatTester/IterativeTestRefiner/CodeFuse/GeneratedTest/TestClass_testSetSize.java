package de.waldheinz.fs.fat;
import de.waldheinz.fs.util.RamDisk;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import de.waldheinz.fs.fat.FatFileSystem;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import de.waldheinz.fs.fat.Fat;
import de.waldheinz.fs.fat.ClusterChain;
import java.nio.channels.SeekableByteChannel;
import de.waldheinz.fs.fat.RamDisk;
// original test path: waldheinz_fat32-lib###waldheinz_fat32-lib/src/test/java/de/waldheinz/fs/fat/ClusterChainTest###testSetSize
public class TestClass_testSetSize {
    private RamDisk ramdisk;
    private FatFileSystem fs;
    private Fat fat;
    private ClusterChain cc;
    @Before
    public void setup() throws Exception{
        ramdisk = new RamDisk(1024 * 1024);
        fs = new FatFileSystem(ramdisk, 0);
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