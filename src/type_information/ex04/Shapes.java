package type_information.ex04;


//: typeinfo/Shapes.java
import type_information.shapes.Circle;
import type_information.shapes.Rhomboid;
import type_information.shapes.Shape;


public class Shapes {
    public static void main(String[] args) {
        Rhomboid rhomboid = new Rhomboid();
        Shape shape = rhomboid;
        if(shape instanceof Circle) {
            Circle circle = (Circle)shape;
            System.out.println(circle);
        }
    }
}