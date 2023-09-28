package edu.jhu.prim.util.math;

import edu.jhu.prim.util.SafeCast;


public class FastMath {

    public static final double LOG2 = log(2);
    //@Opt(hasArg = true, description = "Whether to use a log-add table or log-add exact.")
    public static boolean useLogAddTable = false;
    
    public static int factorial(int n)
    {
        if( n <= 1 ) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Adds two probabilities that are stored as log probabilities.
     * @param x log(p)
     * @param y log(q)
     * @return log(p + q) = log(exp(x) + exp(y))
     */
    public static double logAdd(double x, double y) {
        if (FastMath.useLogAddTable) {
            return SmoothedLogAddTable.logAdd(x,y);
        } else {
            return FastMath.logAddExact(x,y);
        }
    }

    /**
     * Subtracts two probabilities that are stored as log probabilities. 
     * Note that x >= y.
     * 
     * @param x log(p)
     * @param y log(q)
     * @return log(p - q) = log(exp(x) - exp(y))
     * @throws IllegalStateException if x < y
     */
    public static double logSubtract(double x, double y) {
        if (FastMath.useLogAddTable) {
            return SmoothedLogAddTable.logSubtract(x,y);
        } else {
            return FastMath.logSubtractExact(x,y);
        }
    }

    public static double logAddExact(double x, double y) {
            
        // p = 0 or q = 0, where x = log(p), y = log(q)
        if (Double.NEGATIVE_INFINITY == x) {
            return y;
        } else if (Double.NEGATIVE_INFINITY == y) {
            return x;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (y == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
    
        // p != 0 && q != 0
        if (y <= x) {
            return x + Math.log1p(FastMath.exp(y - x));
        } else {
            return y + Math.log1p(FastMath.exp(x - y));
        }
    }

    /**
     * Subtracts two probabilities that are stored as log probabilities. 
     * Note that x >= y.
     * 
     * @param x log(p)
     * @param y log(q)
     * @return log(p - q) = log(exp(p) - exp(q))
     * @throws IllegalStateException if x < y
     */
    public static double logSubtractExact(double x, double y) {
        if (x < y) {
            throw new IllegalStateException("x must be >= y. x=" + x + " y=" + y);
        }
        
        // p = 0 or q = 0, where x = log(p), y = log(q)
        if (Double.NEGATIVE_INFINITY == y) {
            return x;
        } else if (Double.NEGATIVE_INFINITY == x) {
            return y;
        } else if (x == y) {
            return Double.NEGATIVE_INFINITY;
        }
        
        // p != 0 && q != 0
        //return x + Math.log1p(-FastMath.exp(y - x));
        // 
        // The method below is more numerically stable for small differences in x and y.
        // See paper: http://cran.r-project.org/web/packages/Rmpfr/vignettes/log1mexp-note.pdf
        return x + log1mexp(x - y);
    }
    
    /** f(a) = log(1 - exp(-a)) */
    public static double log1mexp(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("a must be > 0: " + a);
        } else if (a <= 0.693) {
            return Math.log(-Math.expm1(-a));
        } else {
            return Math.log1p(-Math.exp(-a));
        }
    }

    public static double log(double d) {
        return Math.log(d);
    }

    public static double exp(double d) {
        return Math.exp(d);
    }

    public static double log2(double d) {
        return log(d) / FastMath.LOG2;
    }

    public static double logForIlp(double weight) {
        if (weight == 0.0 || weight == -0.0) {
            // CPLEX doesn't accept exponents larger than 37 -- it seems to be
            // cutting off at something close to the 32-bit float limit of
            // 3.4E38.
            // 
            // Before, we used -1E25 since we could add 1 trillion of these
            // together and stay in in the coefficient limit.
            //
            // Now, we use -1E10 because -1E25 causes numerical stability issues
            // for the simplex algorithm
            return -1E10;
        }
        return log(weight);
    }
    
    public static double sqrt(double value) {
        // TODO: Switch to a fast implementation is this gets used more heavily.
        return Math.sqrt(value);
    }
    
    /* --------- Float versions which just cast to Double. ---------- */
    public static float log(float d) {
        return SafeCast.safeDoubleToFloat(Math.log((double) d));
    }

    public static float exp(float d) {
        return SafeCast.safeDoubleToFloat(Math.exp((double) d));
    }

    public static float log2(float d) {
        return SafeCast.safeDoubleToFloat(log2((double) d));
    }
    
    public static float logForIlp(float d) {
        return SafeCast.safeDoubleToFloat(logForIlp((double) d));
    }

    public static float logAdd(float x, float y) {
        return SafeCast.safeDoubleToFloat(logAdd((double) x, (double) y));
    }

    public static float logSubtract(float x, float y) {
        return SafeCast.safeDoubleToFloat(logSubtract((double) x, (double) y));
    }
    
    public static float sqrt(float value) {
        return SafeCast.safeDoubleToFloat(sqrt((double) value));
    }
    /* --------------------------------------------------------------- */


    /**
     * Modulo operator where all numbers evaluate to a positive remainder.
     * 
     * @param val The value to mod.
     * @param mod The mod.
     * @return val modulo mod
     */
    public static int mod(int val, int mod) {
        val = val % mod;
        if (val < 0) {
            val += mod;
        }
        return val;
    }
    
}
