//: net/mindview/util/ThreeTuple.java
package containers.ex28.tuple;


public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof ThreeTuple) {
            ThreeTuple<?, ?, ?> t = (ThreeTuple<?, ?, ?>)o;
            return hashCode() - t.hashCode();
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + third.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ThreeTuple) {
            ThreeTuple<?, ?, ?> t = (ThreeTuple<?, ?, ?>)o;
            return first.equals(t.first) &&
                    second.equals(t.second) &&
                    third.equals(t.first);
        }
        return false;
    }
}