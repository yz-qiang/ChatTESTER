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
    URI uri = new URI("file:
    Path path = Paths.get(uri);
    String result = FileUtil.getNameWithoutSuffix(path);
    assertEquals("file", result);
}
}