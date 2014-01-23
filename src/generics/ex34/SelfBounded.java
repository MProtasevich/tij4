package generics.ex34;

public abstract class SelfBounded<T extends SelfBounded<T>> {
    public abstract T f(T t);

    public T g(T t) {
        return f(t);
    }
}