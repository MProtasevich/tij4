//: net/mindview/util/FourTuple.java
package containers.ex28.tuple;


public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof FourTuple) {
            FourTuple<?, ?, ?, ?> tuple = (FourTuple<?, ?, ?, ?>)o;
            return hashCode() - tuple.hashCode();
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + fourth.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof FourTuple) {
            FourTuple<?, ?, ?, ?> tuple = (FourTuple<?, ?, ?, ?>)o;
            return first.equals(tuple.first) &&
                    second.equals(tuple.second) &&
                    third.equals(tuple.third) &&
                    fourth.equals(tuple.fourth);
        }
        return false;
    }
}