package edu.jhu.prim.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BitSetBinaryMatrixTest {

    @Test
    public void testRowColumnCounts() {
        BitSetBinaryMatrix bsbm = new BitSetBinaryMatrix(10, 5);
        bsbm.increment(1, 1);
        bsbm.increment(1, 2);
        bsbm.increment(1, 3);
        bsbm.increment(1, 4);
        bsbm.increment(2, 2);
        bsbm.increment(2, 4);
        bsbm.increment(3, 2);
        bsbm.increment(7, 4);
        
        bsbm.decrement(1, 4);
        bsbm.decrement(3, 2);
        
        assertEquals(bsbm.getRowCount(1), 3);
        assertEquals(bsbm.getRowCount(2), 2);
        assertEquals(bsbm.getRowCount(7), 1);
        assertEquals(bsbm.getRowCount(0), 0);
        assertEquals(bsbm.getRowCount(3), 0);
        
        assertEquals(bsbm.getColumnCount(1), 1);
        assertEquals(bsbm.getColumnCount(2), 2);
        assertEquals(bsbm.getColumnCount(3), 1);
        assertEquals(bsbm.getColumnCount(4), 2);
    }
    
    @Test
    public void testAnd() {
        BitSetBinaryMatrix mat1 = new BitSetBinaryMatrix(2, 2);
        mat1.set(0, 0, true);
        mat1.set(0, 1, true);
        mat1.set(1, 0, true);
        mat1.set(1, 1, false);
        
        BitSetBinaryMatrix mat2 = new BitSetBinaryMatrix(2, 2);
        mat2.set(0, 0, true);
        mat2.set(0, 1, false);
        mat2.set(1, 0, true);
        mat2.set(1, 1, true);

        mat1.and(mat2);
        assertEquals(mat1.get(0, 0), true);
        assertEquals(mat1.get(0, 1), false);
        assertEquals(mat1.get(1, 0), true);
        assertEquals(mat1.get(1, 1), false);
    }

    @Test
    public void testOr() {
        BitSetBinaryMatrix mat1 = new BitSetBinaryMatrix(2, 2);
        mat1.set(0, 0, true);
        mat1.set(0, 1, true);
        mat1.set(1, 0, false);
        mat1.set(1, 1, false);
        
        BitSetBinaryMatrix mat2 = new BitSetBinaryMatrix(2, 2);
        mat2.set(0, 0, false);
        mat2.set(0, 1, true);
        mat2.set(1, 0, true);
        mat2.set(1, 1, false);

        mat1.or(mat2);
        assertEquals(mat1.get(0, 0), true);
        assertEquals(mat1.get(0, 1), true);
        assertEquals(mat1.get(1, 0), true);
        assertEquals(mat1.get(1, 1), false);
    }
    
}
