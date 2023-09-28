package edu.jhu.prim.map;

import java.util.Arrays;
import java.util.Iterator;

import edu.jhu.prim.arrays.DoubleArrays;
import edu.jhu.prim.arrays.IntArrays;
import edu.jhu.prim.list.DoubleArrayList;
import edu.jhu.prim.list.IntArrayList;
import edu.jhu.prim.sort.IntDoubleSort;
import edu.jhu.prim.sort.IntSort;
import edu.jhu.prim.tuple.Pair;
import edu.jhu.prim.util.Lambda.FnIntDoubleToDouble;
import edu.jhu.prim.util.Lambda.FnIntDoubleToVoid;
import edu.jhu.prim.vector.AbstractIntDoubleVector;

/**
 * A primitives map from ints to doubles. The map is stored by keeping a sorted
 * array of indices, and an array of their corresponding values. This is useful
 * when an extremely compact representation of the map is needed.
 * 
 * @author mgormley
 */
public class IntDoubleSortedMap extends AbstractIntDoubleVector implements IntDoubleMap {
    
    private static final long serialVersionUID = 1L;
	protected int[] indices;
	protected double[] values;
	protected int used; // TODO: size
	
	public IntDoubleSortedMap() {
	    this(0);
	}
	
	public IntDoubleSortedMap(int initialSize) {
	    this.used = 0;
	    this.indices= new int[initialSize];
        this.values = new double[initialSize];
	}

	public IntDoubleSortedMap(int[] index, double[] data) {
		if (!IntSort.isSortedAscAndUnique(index)) {
			throw new IllegalStateException("Indices are not sorted ascending");
		}
		
		this.used = index.length;
		this.indices = index;
		this.values = data;
	}

	public IntDoubleSortedMap(IntDoubleSortedMap other) {
		this.used = other.used;
		this.indices = IntArrays.copyOf(other.indices);
		this.values = DoubleArrays.copyOf(other.values);
	}

    public IntDoubleSortedMap(IntDoubleHashMap other) {
        Pair<int[], double[]> pair = other.getIndicesAndValues();
        IntDoubleSort.sortIndexAsc(pair.get1(), pair.get2());
        this.used = other.size();
        this.indices = pair.get1();
        this.values = pair.get2();
    }
    
    //	// TODO: we need to break up Sort into SortIntDouble, SortIntDouble before adding this constructor.
    //	public SortedIntDoubleMap(PIntDoubleHashMap other) {
    //        Pair<int[], double[]> ivs = other.getIndicesAndValues();
    //        this.indices = ivs.get1();
    //        this.values = ivs.get2();
    //        this.used = indices.length;
    //        Sort.sortIndexAsc(indices, values);
    //	}

	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#clear()
     */
	@Override
    public void clear() {
		this.used = 0;
	}
	
	// TODO: rename to containsKey.
	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#contains(int)
     */
	@Override
    public boolean contains(int idx) {
		return Arrays.binarySearch(indices, 0, used, idx) >= 0;
	}
	
	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#get(int)
     */
	@Override
    public double get(int idx) {
		int i = Arrays.binarySearch(indices, 0, used, idx);
		if (i < 0) {
			throw new IllegalArgumentException("This map does not contain the key: " + idx);
		}
		return values[i];
	}
	
	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#getWithDefault(int, double)
     */
	@Override
    public double getWithDefault(int idx, double defaultVal) {
		int i = Arrays.binarySearch(indices, 0, used, idx);
		if (i < 0) {
			return defaultVal;
		}
		return values[i];
	}
	
	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#remove(int)
     */
	@Override
    public void remove(int idx) {
		int i = Arrays.binarySearch(indices, 0, used, idx);
		if (i < 0) {
			throw new IllegalArgumentException("This map does not contain the key: " + idx);
		}		
		// Shift the values over.
		System.arraycopy(indices, i+1, indices, i, used - i - 1);
		System.arraycopy(values, i+1, values, i, used - i - 1);
		used--;
	}
	
	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#put(int, double)
     */
	@Override
    public double put(int idx, double val) {
	    double old = 0;
		int i = Arrays.binarySearch(indices, 0, used, idx);
		if (i >= 0) {
			// Just update the value.
		    old = values[i];
			values[i] = val;
			return old;
		} 
		int insertionPoint = -(i + 1);
		indices = insert(indices, insertionPoint, idx);
		values = insert(values, insertionPoint, val);
		used++;
		return old;
	}
	
    /* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#put(int, double)
     */
    @Override
    public void add(int idx, double val) {
        int i = Arrays.binarySearch(indices, 0, used, idx);
        if (i >= 0) {
            // Just add to the existing value.
            values[i] += val;
            return;
        } 
        int insertionPoint = -(i + 1);
        indices = insert(indices, insertionPoint, idx);
        values = insert(values, insertionPoint, val);
        used++;
    }
    
    public void apply(FnIntDoubleToDouble lambda) {
        for (int i=0; i<used; i++) {
            values[i] = lambda.call(indices[i], values[i]);
        }
    }

    public void iterate(FnIntDoubleToVoid lambda) {
        for (int i=0; i<used; i++) {
            lambda.call(indices[i], values[i]);
        }
    }
	
	private final int[] insert(int[] array, int i, int val) {
		if (used >= array.length) {
			// Increase the capacity of the array.
			array = IntArrayList.ensureCapacity(array, used+1);
		}
		if (i < used) {
			// Shift the values over.
			System.arraycopy(array, i, array, i+1, used - i);
		}
		// Insert the new index into the array.
		array[i] = val;
		return array;
	}
		
    /*  */
	
	private final double[] insert(double[] array, int i, double val) {
		if (used >= array.length) {
			// Increase the capacity of the array.
			array = DoubleArrayList.ensureCapacity(array, used+1);
		}
		if (i < used) {
			// Shift the values over.
			System.arraycopy(array, i, array, i+1, used - i);
		}
		// Insert the new index into the array.
		array[i] = val;
		return array;
	}
	
	/*  */

	public class IntDoubleEntryImpl implements IntDoubleEntry {
		private int i;
		public IntDoubleEntryImpl(int i) {
			this.i = i;
		}
		public int index() {
			return indices[i];
		}
		public double get() {
			return values[i];
		}
    }

    /**
     * This iterator is fast in the case of for(Entry e : vector) { }, however a
     * given entry should not be used after the following call to next().
     */
    public class IntDoubleIterator implements Iterator<IntDoubleEntry> {

        // The current entry.
        private IntDoubleEntryImpl entry = new IntDoubleEntryImpl(-1);

        @Override
        public boolean hasNext() {
            return entry.i + 1 < used;
        }

        @Override
        public IntDoubleEntry next() {
            entry.i++;
            return entry;
        }

        @Override
        public void remove() {
            throw new RuntimeException("operation not supported");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.jhu.util.vector.IntDoubleMap#iterator()
     */
	@Override
	public Iterator<IntDoubleEntry> iterator() {
		return new IntDoubleIterator();
	}


	/* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#size()
     */
	@Override
    public int size() {
		return used;
	}

	public int getUsed() {
		return used;
	}	

    /* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#getIndices()
     */
    @Override
    public int[] getIndices() {
        if (used == indices.length)
            return indices;

        int[] tmpIndices = new int[used];
        for (int i = 0; i < used; i++) {
        	tmpIndices[i] = indices[i];
        }
        return tmpIndices;
    }
    
    /* (non-Javadoc)
     * @see edu.jhu.util.vector.IntDoubleMap#getValues()
     */
    @Override
    public double[] getValues() {
        if (used == values.length)
            return values;

        double[] tmpValues = new double[used];
        for (int i = 0; i < used; i++) {
        	tmpValues[i] = values[i];
        }
        return tmpValues;
    }
		
    /**
     * Gets the INTERNAL representation of the indices. Great care should be
     * taken to avoid touching the values beyond the used indices.
     */
    public int[] getInternalIndices() {
        return indices;
    }

    /**
     * Gets the INTERNAL representation of the values. Great care should be
     * taken to avoid touching the values beyond the used values.
     */
    public double[] getInternalValues() {
        return values;
    }
    
}
