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
    public void testGetNameWithoutExtension() throws Exception{
        URI uri = new URI("http:
        try {
            Assert.assertTrue(!uri.isAbsolute());
            final String fileNameWithExtention = Paths.get(uri).getFileName().toString();
            System.out.println("\nfileNameWithExtention : "+fileNameWithExtention+"\n\n");
            final String expectedResult="myFile";
            final String actualResult=FileUtil.getNameWithoutSuffix(Paths.get("/"+fileNameWithExtention));
            assertEquals(expectedResult,actualResult );
        } catch (URISyntaxException e){
           throw new RuntimeException ("Invalid URL",e);
        }
    }
@Test 
    public void testGetNameWithoutExtension_withAbsolutePath(){
      final String absoluteFilePath="/home/user/documents/test.pdf" ;
      final String result=FileUtil.getNameWithoutSuffix(Paths.get(absoluteFilePath)) ; 
      assertNotEquals("",result ) ; 
  }
}