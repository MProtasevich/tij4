//: net/mindview/util/Sets.java
package generics.ex17;


import java.util.*;


public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = getNewSet(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = getNewSet(a);
        result.retainAll(b);
        return result;
    }

    // Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = getNewSet(superset);
        result.removeAll(subset);
        return result;
    }

    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static <T> Set<T> getNewSet(Set<T> a) {
        Set<T> result;
        if(a instanceof EnumSet) {
            result = ((EnumSet)a).clone();
        } else {
            result = new HashSet<T>(a);
        }

        return result;
    }
}