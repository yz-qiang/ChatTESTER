package edu.jhu.prim.matrix;

import java.util.BitSet;

import edu.jhu.prim.arrays.IntArrays;
import edu.jhu.prim.matrix.infinite.ColumnCountIterator;
public class BitSetBinaryMatrix implements BinaryMatrix {

    private static final long serialVersionUID = 6324612589688787142L;
    private BitSet[] matrix;
    private int[] columnCounts;
    private int[] rowCounts;

    private final int numRows;
    private final int numCols;

    /**
     * An infinite number of columns is assumed.
     */
    public BitSetBinaryMatrix(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numCols = numColumns;
        matrix = new BitSet[numRows];
        for (int i = 0; i < numRows; i++) {
            matrix[i] = new BitSet();
        }
        columnCounts = new int[numCols];
        rowCounts = new int[numRows];
    }

    public BitSetBinaryMatrix(BitSetBinaryMatrix bsbm) {
        matrix = new BitSet[bsbm.matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = (BitSet) bsbm.matrix[i].clone();
        }
        columnCounts = IntArrays.copyOf(bsbm.columnCounts, bsbm.columnCounts.length);
        if (bsbm.rowCounts != null) {
            rowCounts = IntArrays.copyOf(bsbm.rowCounts, bsbm.rowCounts.length);
        } else {
            rowCounts = new int[bsbm.numRows];
        }
        numRows = bsbm.numRows;
        numCols = bsbm.numCols;
    }

    @Override
    public void set(BinaryMatrix bm) {
        if (bm instanceof BitSetBinaryMatrix) {
            BitSetBinaryMatrix bsbm = (BitSetBinaryMatrix)bm;
            assert(matrix.length == bsbm.matrix.length);
            assert(numRows == bsbm.numRows);
            assert(numCols == bsbm.numCols);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i].clear();
                matrix[i].or(bsbm.matrix[i]);
            }
            IntArrays.copy(bsbm.columnCounts, columnCounts);
            if (bsbm.rowCounts != null) {
                IntArrays.copy(bsbm.rowCounts, rowCounts);
            } else {
                rowCounts = new int[bsbm.numRows];
            }
        } else {
            throw new IllegalArgumentException("Expected BitSetBinaryMatrix");
        }
    }

    public int getColumnCount(int col) {
        return columnCounts[col];
    }

    public int getRowCount(int row) {
        return rowCounts[row];
    }
    
    public int getCount() {
        return IntArrays.sum(columnCounts);
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numCols;
    }

    public Iterable<Integer> getActiveColumns() {
        return new ColumnCountIterator(columnCounts);
    }

    public boolean[][] getMatrix() {
        boolean[][] bmat = new boolean[numRows][numCols];
        for (int i = 0; i < bmat.length; i++) {
            for (int k = 0; k < bmat[i].length; k++) {
                bmat[i][k] = matrix[i].get(k);
            }
        }
        return bmat;
    }

    public boolean decrement(int row, int col) {
        checkIndices(row, col);

        if (matrix[row].get(col)) {
            columnCounts[col]--;
            rowCounts[row]--;
            matrix[row].set(col, false);
            return true;
        }
        return false;
    }

    public boolean increment(int row, int col) {
        checkIndices(row, col);

        if (!matrix[row].get(col)) {
            columnCounts[col]++;
            rowCounts[row]++;
            matrix[row].set(col, true);
            return false;
        }
        return true;
    }

    private void checkIndices(int row, int col) {
        checkRow(row);
        checkColumn(col);
    }

    private void checkColumn(int col) {
        if (col >= numCols) {
            throw new IllegalArgumentException("Column exceeds numCols: " + col);
        }
    }

    private void checkRow(int row) {
        if (row >= numRows) {
            throw new IllegalArgumentException("Row exceeds numRows: " + row);
        }
    }

    public boolean get(int row, int col) {
        return matrix[row].get(col);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean[][] matrix = getMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void setAll(boolean val) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                set(i, j, val);
            }
        }
    }

    public boolean set(int row, int col, boolean val) {
        if (val) {
            return increment(row, col);
        } else {
            return decrement(row, col);
        }
    }

    public void and(BitSetBinaryMatrix other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("matrices must have the same dimensions");
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                boolean and = this.get(i, j) && other.get(i, j);
                set(i, j, and);
            }
        }
    }

    public void or(BitSetBinaryMatrix other) {
        if (this.numRows != other.numRows || this.numCols != other.numCols) {
            throw new IllegalArgumentException("matrices must have the same dimensions");
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                boolean or = this.get(i, j) || other.get(i, j);
                set(i, j, or);
            }
        }
    }

}
