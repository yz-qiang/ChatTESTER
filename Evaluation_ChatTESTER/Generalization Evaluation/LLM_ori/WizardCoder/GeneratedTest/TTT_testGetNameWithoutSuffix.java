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
public class TTT_testGetNameWithoutSuffix {
@Test
public void testGetNameWithoutSuffix() throws IOException {
    Path fileWithExtension = Paths.get("testFile.txt"); 
    try {
        assertEquals("", FileUtil.getNameWithoutSuffix(null));
        assertEquals(".txt", Files.getFileExtension(fileWithExtension).orElseThrow());
        final URI uri = new URI("http:
        assertEquals("-unknown-", FileUtil.getNameWithoutSuffix(() -> null));
    } catch (AssertionError e) {
        throw ExceptionUtil.uncheck(e); 
    } 
}
}