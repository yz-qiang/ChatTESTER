package edu.jhu.prim.vector;

import java.io.Serializable;

import edu.jhu.prim.util.Lambda.FnLongDoubleToDouble;
import edu.jhu.prim.util.Lambda.FnLongDoubleToVoid;

/** 
 * Vector with long indices and double values.
 * 
 * @author mgormley
 */
//TODO: Extend Iterable<LongDoubleEntry>.
public interface LongDoubleVector extends Serializable {

    /** Gets the value at the specified index. */
    double get(long idx);

    /** Sets the value at the specified index and returns the previous value. */
    double set(long idx, double val);

    /** Adds to the current value at the specified index. */
    void add(long idx, double val);

    /** Scales each entry in this vector by the given multiplier. */
    void scale(double multiplier);

    /** Computes the dot product of this vector with the other vector. */
    double dot(double[] other);
    
    /** Computes the dot product of this vector with the other vector. */
    double dot(LongDoubleVector other);

    /**
     * Applies the function to each (explicit) entry in the vector. The caller
     * should make no assumptions about the order in which the entries will be
     * visited.
     */
    void apply(FnLongDoubleToDouble function);

    /**
     * Calls the function on each (explicit) entry in the vector. The caller
     * should make no assumptions about the order in which the entries will be
     * visited.
     */
    void iterate(FnLongDoubleToVoid function);
    
    /** Updates this vector to be the entrywise sum of this vector with the other. */
    void add(LongDoubleVector other);
    
    /** Updates this vector to be the entrywise difference of this vector with the other. */
    void subtract(LongDoubleVector other);
    
    /** Updates this vector to be the entrywise product (i.e. Hadamard product) of this vector with the other. */
    void product(LongDoubleVector other);
    
    /** Gets a deep copy of this vector. */
    LongDoubleVector copy();
    
    /**
     * Gets the number of implicit entries.
     * 
     * For a dense vector, this is just the size of the vector.
     * 
     * For a sparse vector, this is index after the last explicit entry in the
     * vector. This corresponds to (1 + i) where i is the highest index
     * explicitly represented.
     * 
     * The contract of this method is that for any j >=
     * this.getNumImplicitEntries(), this.get(j) will return 0.
     * 
     * @return The number of implicit entries.
     */
    long getNumImplicitEntries();
    
    /** Gets a double array representation of this vector. */
    double[] toNativeArray();
    
    /** Gets the sum of all the explicit entries in this vector. */
    double getSum();

    /** Gets the max of all the explicit entries in this vector. */
    double getMax();

    /** Gets the index of the max of all the explicit entries in this vector. */
    long getArgmax();
    
    /** Gets the min of all the explicit entries in this vector. */
    double getMin();

    /** Gets the index of the min of all the explicit entries in this vector. */
    long getArgmin();

    /** Gets the sum of the squares all the explicit entries in this vector. */
    double getL2Norm();

    /** Gets the sum of all the explicit entries in this vector. */
    double getInfNorm();
    
}