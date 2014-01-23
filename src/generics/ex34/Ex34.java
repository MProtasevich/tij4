package generics.ex34;


public class Ex34 extends SelfBounded<Ex34> {

    @Override
    public Ex34 f(Ex34 ex34) {
        return ex34;
    }

    public static void main(String[] args) {
        Ex34 ex34 = new Ex34();
        ex34.f(ex34).g(ex34);
    }
}