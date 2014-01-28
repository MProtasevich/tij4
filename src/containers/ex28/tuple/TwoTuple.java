//: net/mindview/util/TwoTuple.java
package containers.ex28.tuple;


public class TwoTuple<A, B> implements Comparable<Object> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public int compareTo(Object t) {
        if(t instanceof TwoTuple) {
            return this.hashCode() - t.hashCode();
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + first.hashCode();
        result = result * 37 + second.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object arg0) {
        if(arg0 instanceof TwoTuple) {
            TwoTuple<?, ?> tt = (TwoTuple<?, ?>)arg0;
            return first.equals(tt.first) && second.equals(tt.second);
        }
        return false;
    }
}