package edu.jhu.prim.map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.jhu.prim.util.IntJUnitUtils;
// original test path: mgormley_prim###mgormley_prim/src/test/java/edu/jhu/prim/map/IntObjectHashMapTest###testKeys
public class TTT_testKeys {
@Test public void testGetKeys() throws Exception{
    IntObjectHashMap<String> m = new IntObjectHashMap<>();
    String valueA = "a";
    String valueB = "b";
    Integer keyA = 56789234; 
    Integer keyB = 12345678;  
    assertEquals("Map should be empty", true, m.isEmpty());    
    assertTrue("Key A not added successfully.",m.putIfAbsent(keyA, valueA));   
    assertFalse("Duplicate Key B was allowed!",m.putIfAbsent(keyB, valueB));     
    assertArrayEquals("Incorrect Keys returned by getKeys()", 
            Arrays.asList(new Integer[]{keyA}).toArray(),
            m.getKeys().toArray()); 
    assertSame("Value associated with wrong key","a", m.get(keyA).toString());       
} 
protected int getRandomIntegerInRange(int minVal, int maxVal){
        Random rand = new Random(); 
        return Math.abs((rand.nextInt())) % ((maxVal + 1)- minVal)+ minVal ;      
  }
}