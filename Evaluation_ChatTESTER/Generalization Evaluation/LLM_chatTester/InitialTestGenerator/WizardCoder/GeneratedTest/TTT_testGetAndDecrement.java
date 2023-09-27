package org.apache.commons.lang3.mutable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// original test path: ManfredTremmel_gwt-commons-lang3###ManfredTremmel_gwt-commons-lang3/src/test/java/org/apache/commons/lang3/mutable/MutableIntTest###testGetAndDecrement
public class TTT_testGetAndDecrement {
@Test 
    public void testGetAndDecrement_Atomicity() {
        MutableInt mutableInteger = new MutableInt(-50);
        Thread t1 = new Thread(() -> assertEquals("-49", "" + mutableInteger.getAndDecrement())); 
        Thread t2 = new Thread(() -> assertFalse("" + mutableInteger)); 
        try{
            t1.start(); 
            TimeUnit.SECONDS.sleep(3L);  
            assertTrue("Thread not finished yet.",t1.isAlive()); 
            while(!mutableInteger.equals(new MutableInt())) 
                ;   
            t2.start(); 
            TimeUnit.MILLISECONDS.sleep(700L);
            assertNotEquals("",""+mutableInteger,"Mutable object has been modified.");
        } catch (InterruptedException e){
            fail("Execution interrupted");
        } finally {
            System.out.println("\nFinal Value : "+mutableInteger+"\n");
        }
    }
}