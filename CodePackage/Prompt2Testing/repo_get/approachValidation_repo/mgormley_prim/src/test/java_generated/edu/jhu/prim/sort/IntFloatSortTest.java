package edu.jhu.prim.sort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.prim.Primitives;
import edu.jhu.prim.arrays.FloatArrays;
import edu.jhu.prim.arrays.IntArrays;
import edu.jhu.prim.util.FloatJUnitUtils;
import edu.jhu.prim.util.Timer;

public class IntFloatSortTest {
        
    /* ---------- Ints and Floats --------------*/
    
    @Test
    public void testIntFloatSortValuesAsc() {
        float[] values = new float[]{ 1, 3, 2, -1, 5};
        int[] index = IntArrays.range(values.length);
        IntFloatSort.sortValuesAsc(values, index);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));
        
        FloatJUnitUtils.assertArrayEquals(new float[]{ -1, 1, 2, 3, 5}, values, Primitives.DEFAULT_FLOAT_DELTA);
        Assert.assertArrayEquals(new int[]{ 3, 0, 2, 1, 4}, index);
    }
    
    @Test
    public void testIntFloatSortValuesDesc() {
        float[] values = new float[]{ 1, 3, 2, -1, 5};
        int[] index = IntArrays.range(values.length);
        IntFloatSort.sortValuesDesc(values, index);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));
        
        FloatJUnitUtils.assertArrayEquals(new float[]{ 5, 3, 2, 1, -1}, values, Primitives.DEFAULT_FLOAT_DELTA);
        Assert.assertArrayEquals(new int[]{ 4, 1, 2, 0, 3}, index);
    }
    
    @Test
    public void testIntFloatSortValuesInfinitiesAsc() {
        float[] values = new float[]{ 1, Float.POSITIVE_INFINITY, 2, -1, Float.NEGATIVE_INFINITY, 5};
        int[] index = IntArrays.range(values.length);
        IntFloatSort.sortValuesAsc(values, index);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));

        FloatJUnitUtils.assertArrayEquals(new float[]{Float.NEGATIVE_INFINITY, -1, 1, 2, 5, Float.POSITIVE_INFINITY}, values, Primitives.DEFAULT_FLOAT_DELTA);
        Assert.assertArrayEquals(new int[]{ 4, 3, 0, 2, 5, 1 }, index);
    }
    
    @Test
    public void testIntFloatSortValuesInfinitiesDesc() {
        float[] values = new float[]{ 1, Float.POSITIVE_INFINITY, 2, -1, Float.NEGATIVE_INFINITY, 5};
        int[] index = IntArrays.range(values.length);
        IntFloatSort.sortValuesDesc(values, index);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));
        
        FloatJUnitUtils.assertArrayEquals(new float[]{Float.POSITIVE_INFINITY,  5, 2, 1, -1, Float.NEGATIVE_INFINITY}, values, Primitives.DEFAULT_FLOAT_DELTA);
        Assert.assertArrayEquals(new int[]{ 1, 5, 2, 0, 3, 4 }, index);
    }    

    @Test
    public void testIntFloatSortIndexAsc() {
        float[] values = new float[]{ 1, 3, 2, -1, 5};
        int[] index = new int[] { 1, 4, 5, 8, 3};
        IntFloatSort.sortIndexAsc(index, values);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));
        
        FloatJUnitUtils.assertArrayEquals(new float[]{ 1, 5, 3, 2, -1 }, values, Primitives.DEFAULT_FLOAT_DELTA);
        Assert.assertArrayEquals(new int[]{ 1, 3, 4, 5, 8 }, index);
    }

    @Test
    public void testIntFloatSortIndexDesc() {
        float[] values = new float[]{ 1, 3, 2, -1, 5};
        int[] index = new int[] { 1, 4, 5, 8, 3};
        IntFloatSort.sortIndexDesc(index, values);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));
        
        FloatJUnitUtils.assertArrayEquals(new float[]{ -1, 2, 3, 5, 1 }, values, Primitives.DEFAULT_FLOAT_DELTA);
        Assert.assertArrayEquals(new int[]{ 8, 5, 4, 3, 1 }, index);
    }
    
    @Test
    public void testRandomArraysSortAsc() {        
        for (int i=0; i<10; i++) {           
            // Get random arrays.
            int size = 100;
            float[] values = new float[size];
            int[] index = new int[size];
            for (int j=0; j<size; j++) {
                values[j] = (float) j;
                index[j] = (int) j;
            }
            FloatArrays.shuffle(values);
            IntArrays.shuffle(index);
            
            // Sort and ONLY check the sorted array, not both.
            assertTrue(!IntSort.isSortedAsc(index));
            IntFloatSort.sortIndexAsc(index, values);
            assertTrue(IntSort.isSortedAsc(index));
            
            assertTrue(!FloatSort.isSortedAsc(values));
            IntFloatSort.sortValuesAsc(values, index);
            assertTrue(FloatSort.isSortedAsc(values));
        }
    }
    
    @Test
    public void testRandomArraysSortDesc() {        
        for (int i=0; i<10; i++) {           
            // Get random arrays.
            int size = 100;
            float[] values = new float[size];
            int[] index = new int[size];
            for (int j=0; j<size; j++) {
                values[j] = (float) j;
                index[j] = (int) j;
            }
            FloatArrays.shuffle(values);
            IntArrays.shuffle(index);
            
            // Sort and ONLY check the sorted array, not both.
            assertTrue(!IntSort.isSortedDesc(index));
            IntFloatSort.sortIndexDesc(index, values);
            assertTrue(IntSort.isSortedDesc(index));
            
            assertTrue(!FloatSort.isSortedDesc(values));
            IntFloatSort.sortValuesDesc(values, index);
            assertTrue(FloatSort.isSortedDesc(values));
        }
    }
    

    /** 
     * OUTPUT:
     * Total (ms) for recursive: 409.0
     * Total (ms) for stack: 410.0
     */
    @Test
    public void testSortSpeed() {  
        int numTrials = 1000; // Add a zero for results above.
        int size = 1000;
        {
            Timer timer = new Timer();
            for (int trial=0; trial<numTrials; trial++) {           
                // Get random arrays.
                float[] values = new float[size];
                int[] index = new int[size];
                for (int j=0; j<size; j++) {
                    values[j] = (float) j;
                    index[j] = (int) j;
                }
                FloatArrays.shuffle(values);
                IntArrays.shuffle(index);
                
                if (trial == numTrials/2) {
                    timer = new Timer();
                }
                
                timer.start();
                IntFloatSort.quicksortIndexRecursive(index, values, 0, index.length-1, true);
                timer.stop();                
            }
            System.out.println("Total (ms) for recursive: " + timer.totMs());
        }
        {
            Timer timer = new Timer();
            for (int trial=0; trial<numTrials; trial++) {           
                // Get random arrays.
                float[] values = new float[size];
                int[] index = new int[size];
                for (int j=0; j<size; j++) {
                    values[j] = (float) j;
                    index[j] = (int) j;
                }
                FloatArrays.shuffle(values);
                IntArrays.shuffle(index);

                if (trial == numTrials/2) {
                    timer = new Timer();
                }
                
                timer.start();
                IntFloatSort.sortIndexAsc(index, values);
                timer.stop();
                
            }
            System.out.println("Total (ms) for stack: " + timer.totMs());
        }
    }
    
    @Test
    public void testSortSpeedPresorted() {  
        int numTrials = 1; // Add a zero for results above.
        int size = Byte.MAX_VALUE;
        {
            Timer timer = new Timer();
            for (int trial=0; trial<numTrials; trial++) {           
                IntFloatSort.numSwaps = 0;
                float[] values = new float[size];
                int[] index = new int[size];
                for (int j=0; j<size; j++) {
                    values[j] = (float) -j;
                    index[j] = (int) -j;
                }

                if (trial == numTrials/2) {
                    timer = new Timer();
                }
                assertTrue(IntSort.isSortedDesc(index));
                timer.start();
                IntFloatSort.sortIndexDesc(index, values);
                timer.stop();     
                assertTrue(IntSort.isSortedDesc(index));
                assertEquals(0, IntFloatSort.numSwaps);

                assertTrue(FloatSort.isSortedDesc(values));
                timer.start();
                IntFloatSort.sortValuesDesc(values, index);
                timer.stop();
                assertTrue(FloatSort.isSortedDesc(values));
                assertEquals(0, IntFloatSort.numSwaps);   
            }
            System.out.println("Num swaps: " + IntFloatSort.numSwaps);
            System.out.println("Total (ms) for descending: " + timer.totMs());
            assertEquals(0, IntFloatSort.numSwaps);
        }
        {
            Timer timer = new Timer();
            for (int trial=0; trial<numTrials; trial++) {  
                IntFloatSort.numSwaps = 0;
                float[] values = new float[size];
                int[] index = new int[size];
                for (int j=0; j<size; j++) {
                    values[j] = (float) j;
                    index[j] = (int) j;
                }
                
                if (trial == numTrials/2) {
                    timer = new Timer();
                }
                assertTrue(IntSort.isSortedAsc(index));
                timer.start();
                IntFloatSort.sortIndexAsc(index, values);
                timer.stop();     
                assertTrue(IntSort.isSortedAsc(index));
                assertEquals(0, IntFloatSort.numSwaps);

                assertTrue(FloatSort.isSortedAsc(values));
                timer.start();
                IntFloatSort.sortValuesAsc(values, index);
                timer.stop();
                assertTrue(FloatSort.isSortedAsc(values));
                assertEquals(0, IntFloatSort.numSwaps);                
            }
            System.out.println("Num swaps: " + IntFloatSort.numSwaps);
            System.out.println("Total (ms) for ascending: " + timer.totMs());
            assertEquals(0, IntFloatSort.numSwaps);
        }
    }
    
}
