package generics.ex23;


//: generics/FactoryConstraint.java
interface FactoryI<T> {
    T create(Integer t);
}


class Foo2<T> {
    private T x;

    public void get() {
        System.out.println(x);
    }

    public <F extends FactoryI<T>> Foo2(F factory, Integer t) {
        x = factory.create(t);
    }
}


class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create(Integer i) {
        return new Integer(i);
    }
}


class Widget {
    private int i;
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create(Integer i) {
            Widget w = new Widget();
            w.i = i;
            return w;
        }
    }

    public int getI() {
        return i;
    }
}


public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(), 1).get();
        new Foo2<Widget>(new Widget.Factory(), 2).get();
    }
}