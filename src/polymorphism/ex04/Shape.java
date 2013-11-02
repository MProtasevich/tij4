//: polymorphism/shape/Shape.java
package polymorphism.ex04;


public class Shape {
    public void draw() {}

    public void erase() {}

    // This method will be used in derived classes,
    // what has not override it
    public void printShape() {
        System.out.println("Shape");
    }
} // /:~