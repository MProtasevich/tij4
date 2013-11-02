//: polymorphism/shape/Triangle.java
package polymorphism.ex03;


public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    public void printShape() {
        System.out.println("Triangle");
    }
} // /:~