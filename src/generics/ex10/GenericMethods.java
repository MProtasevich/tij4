package generics.ex10;


//: generics/GenericMethods.java
public class GenericMethods {
    public <X, Y> void f(X x, Y y, Integer z) {
        System.out.println(x.getClass().getName());
        System.out.println(y.getClass().getName());
        System.out.println(z.getClass().getName());
        System.out.println("===");
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1.0, 1);
        gm.f(1.0F, 'c', 0);
    }
}