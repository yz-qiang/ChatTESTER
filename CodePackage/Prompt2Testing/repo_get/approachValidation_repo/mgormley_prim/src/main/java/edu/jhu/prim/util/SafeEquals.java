package edu.jhu.prim.util;



public class SafeEquals {

    private SafeEquals() {
        // private constructor
    }
    
    public static boolean safeEquals(Object o1, Object o2) {
        if (o1 == null || o2 == null) {
            return o1 == o2;
        } else {
            return o1.equals(o2);
        }
    }

}
