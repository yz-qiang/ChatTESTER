package edu.jhu.prim.iter;

public class LongIncrIter implements LongIter {

    private final long start;
    private final long end;
    private final long incr;   
    private long cur;
        
    /** 
     * Constructs a new IntIter which ranges from start (inclusive) to end (exclusive) by steps of incr.
     * 
     * @param start The first value (inclusive) over which to iterate.
     * @param end The last value (exclusive) over which to iterate.
     * @param incr The increment value.
     */
    public LongIncrIter(long start, long end, long incr) {
        this.start = start;
        this.end = end;
        this.incr = incr;
        this.cur = start;
    }

    /** Standard constructor which increments by 1 from 0 to end. */
    public LongIncrIter(long end) {
        this(0, end, 1);
    }
    
    @Override
    public long next() {
        if (!hasNext()) {
            throw new IllegalStateException();
        }
        long tmp = cur;
        cur += incr;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return cur < end;
    }

    @Override
    public void reset() {
        this.cur = start;
    }
    
}
