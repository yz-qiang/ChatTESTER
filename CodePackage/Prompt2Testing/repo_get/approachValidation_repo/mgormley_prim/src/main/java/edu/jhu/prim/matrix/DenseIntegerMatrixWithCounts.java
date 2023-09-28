package edu.jhu.prim.matrix;

import edu.jhu.prim.arrays.IntArrays;
import edu.jhu.prim.map.IntIntEntry;
public class DenseIntegerMatrixWithCounts implements IntegerMatrix {
    
    private static final long serialVersionUID = -2148653126472159945L;
    
    private int[][] matrix;
	private final int numRows;
	private final int numCols;
    private int[] colCounts;
    private int[] rowCounts;
    
	public DenseIntegerMatrixWithCounts(int numRows, int numCols) {
	    this.numRows = numRows;
	    this.numCols = numCols;
		matrix = new int[numRows][numCols];
		colCounts = new int[numCols];
		rowCounts = new int[numRows];
	} 
	
	public DenseIntegerMatrixWithCounts(DenseIntegerMatrixWithCounts dim) {
	    numRows = dim.numRows;
	    numCols = dim.numCols;
	    matrix = IntArrays.copyOf(dim.matrix);
	    colCounts = IntArrays.copyOf(dim.colCounts, dim.colCounts.length);
	    rowCounts = IntArrays.copyOf(dim.rowCounts, dim.rowCounts.length);
    }
	
	public void set(IntegerMatrix other) {
        if (other instanceof DenseIntegerMatrixWithCounts) {
            DenseIntegerMatrixWithCounts dim = (DenseIntegerMatrixWithCounts)other;
            assert(numRows == dim.numRows);
            assert(numCols == dim.numCols);
            IntArrays.copy(dim.colCounts, colCounts);
            IntArrays.copy(dim.rowCounts, rowCounts);
            for (int row=0; row<numRows; row++) {
                IntArrays.copy(dim.matrix[row], matrix[row]);
            }
        } else {
            throw new IllegalArgumentException("unhandled type: " + other.getClass().getCanonicalName());
        }
    }

    public void decrement(int row, int col) {
		matrix[row][col]--;
		colCounts[col]--;
		rowCounts[row]--;
		assert(matrix[row][col] >= 0);
	    assert(rowCounts[row] >= 0);
	}

	public int get(int row, int col) {
		return matrix[row][col];
	}

    public void set(int row, int col, int value) {
        int diff = value - matrix[row][col];
        colCounts[col] += diff;
        rowCounts[row] += diff;
        matrix[row][col] = value;
    }

    public int getColumnCount(int col) {
        return colCounts[col];
    }

    public int getRowCount(int row) {
        return rowCounts[row];
    }
    
	public int getNumRows() {
        return numRows;
    }
	
	public int getNumColumns() {
        return numCols;
    }

	public void increment(int row, int col) {
		matrix[row][col]++;
		colCounts[col]++;
		rowCounts[row]++;
	}

	public void decrement(int row, int col, int decr) {
	    matrix[row][col] -= decr;
	    colCounts[col] -= decr;
	    rowCounts[row] -= decr;
	    assert(matrix[row][col] >= 0);
	    assert(rowCounts[row] >= 0);
	}

	public void increment(int row, int col, int incr) {
	    matrix[row][col] += incr;
	    colCounts[col] += incr;
	    rowCounts[row] += incr;
	}

    @Override
    public Iterable<IntIntEntry> getRowEntries(int row) {
        throw new RuntimeException("not implemented");
    }

}
