//: polymorphism/shape/Circle.java
package polymorphism.ex04;


public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void printShape() {
        System.out.println("Circle");
    }
} // /:~