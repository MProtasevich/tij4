package polymorphism.ex04;


public class Daimond extends Shape {
    @Override
    public void draw() {
        System.out.println("Diamond.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Diamond.erase()");
    }

    @Override
    public void printShape() {
        System.out.println("Diamond");
    }
}
