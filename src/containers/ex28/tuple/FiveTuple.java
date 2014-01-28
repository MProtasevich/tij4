//: net/mindview/util/FiveTuple.java
package containers.ex28.tuple;


public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth
                + ", " + fifth + ")";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof FiveTuple) {
            FiveTuple<?, ?, ?, ?, ?> tuple = (FiveTuple<?, ?, ?, ?, ?>)o;
            return hashCode() - tuple.hashCode();
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + fifth.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof FiveTuple) {
            FiveTuple<?, ?, ?, ?, ?> tuple = (FiveTuple<?, ?, ?, ?, ?>)o;
            return first.equals(tuple.first) &&
                    second.equals(tuple.second) &&
                    third.equals(tuple.third) &&
                    fourth.equals(tuple.fourth) &&
                    fifth.equals(tuple.fifth);
        }
        return false;
    }
}