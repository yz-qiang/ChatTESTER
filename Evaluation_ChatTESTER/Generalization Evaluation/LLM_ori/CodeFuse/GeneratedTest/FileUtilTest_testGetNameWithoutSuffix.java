package cn.xdean.jex.io;
import cn.xdean.jex.lang.ExceptionUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;
// original test path: XDean_Java-EX###XDean_Java-EX/src/test/java/cn/xdean/jex/io/FileUtilTest###testGetNameWithoutSuffix
public class FileUtilTest_testGetNameWithoutSuffix {
    @Test
    public void testGetNameWithoutSuffix() throws IOException{
        Path path1 = Paths.get("C:\\Users\\User\\Documents\\example.txt");
        assertEquals("example", FileUtil.getNameWithoutSuffix(path1));
        Path path2 = Paths.get("C:\\Users\\User\\Documents\\example");
        assertEquals("example", FileUtil.getNameWithoutSuffix(path2));
        Path path3 = Paths.get("C:\\Users\\User\\Documents\\example.tar.gz");
        assertEquals("example", FileUtil.getNameWithoutSuffix(path3));
        Path path4 = Paths.get("C:\\Users\\User\\Documents\\.");
        assertEquals(".", FileUtil.getNameWithoutSuffix(path4));
        Path path5 = Paths.get("");
        assertNull(FileUtil.getNameWithoutSuffix(path5));
    }
}