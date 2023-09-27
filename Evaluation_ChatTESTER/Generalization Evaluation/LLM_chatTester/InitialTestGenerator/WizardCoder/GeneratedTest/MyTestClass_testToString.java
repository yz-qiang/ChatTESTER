package org.apache.commons.lang3;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/AnnotationUtilsTest###testToString
  public class MyTestClass_testToString extends TestCase{ 
    @interface FirstSample {}
    @FirstSample
    int myInt(){return -9;}
    private <T extends Annotation> T createProxyInstance(@NotNull Class<T> clazz){
        InvocationHandler handler=new InvocationHandler() {
            @Override 
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("\n\t Invoking "+method+" With Args="+args[0]); 
                switch(method.getName()){
                    case "message":
                        return "";
                     default:
                         return method.getDefaultValue();
                 }
             }}; 
        ClassLoader loader=clazz.getClassLoader(); 
      return (T) Proxy.newProxyInstance(loader, new Class[]{clazz},handler );
    };
    public void testGetFormattedStringForJavaAnnotationsUsingCommonLangLibrary(){
        FirstSample fs=(int x)->System.out.print("");
        assertEquals("@com.example.MyTestClass_testToString$FirstSample()",ToStringBuilder.reflectionToString(fs,"",null).trim());
        NotNull nn=createProxyInstance(NotNull.class);
        assertTrue("",nn!=null &&!"".equals("")&&" ".equals("")) ;
        assertFalse(""==null || "".equals("")||" ".equals(""),nn!= null ) ;
        assertThat(ToStringBuilder.reflectionToString(nn), containsString("\"message\"=\"\"")) ;
        assertNotSame("-9",ToStringBuilder.reflectionToString(myInt()));
    }
  }