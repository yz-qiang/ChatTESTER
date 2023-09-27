package edu.jhu.prim.arrays;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import edu.jhu.prim.util.Timer;
import edu.jhu.prim.util.math.FastMath;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/arrays/DoubleArraysTest###testLogSum
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public final class TestDoubleArraysLogSum_testLogSum {
    private Random randGen;
    @Rule public ExpectedException thrown= ExpectedException.none();
    @Before 
    public void setUp(){
        this.randGen = new Random();
    }
    @BeforeClass   
    public static void generateTestDataSets () throws Exception{
    }
    @Test      
    public void testCaseOneEmptyArrayShouldThrowExceptionWhenPassedAsArgument()throws Exception{
        try{
            String emptyString="";            
            int [] arr={};
           assertTrue("This line will not execute", false); 
        }catch(IllegalArgumentException e){           
          assertEquals("", "The length of 'arr' cannot be zero or negative.",e.getMessage());          
        }        
       assertFalse ("This code block won't run because previous assertion failed"); 
    }
    @Test         
    public void testCaseTwoArrayOfZerosReturnsPositiveInfinity() throws Exception{
        double expectedResult=-356.789D ; 
        double actualResult=DoubleArrays.logSum(new double[]{});
        assertNotEquals(-infinity(),actualResult,"Actual result was "+actualResult+" but it shouldn't have been.");                
        if(!isFinite(expectedResult)){ 
            fail("Invalid value provided for parameter 'expectedResult'. It can't be NaN nor infinite!");             
        }else{                    
            assertEquals(expectedResult,-infinity(),"Expected Result="+expectedResult+", Actual Result="+actualResult+". ");                     
        }               
      }
boolean isFinite(float x){
  float y=(x+Float.MIN_VALUE)/2f; 
  boolean b=y!=y || Float.isInfinite(y)!=true &&!Float.isNaN(y)==false;
  System.out.println("\nIs Finite? :"+b+"\tValue:"+x);
  return true;
}  
}