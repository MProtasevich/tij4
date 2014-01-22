package type_information.ex05;

//: typeinfo/Shapes.java
import type_information.shapes.Circle;
import type_information.shapes.Rhomboid;
import type_information.shapes.Shape;
import type_information.shapes.Square;
import type_information.shapes.Triangle;

public class Shapes {
	public static void rotate(Shape shape) {
		if (!(shape instanceof Circle)) {
			System.out.println("rotate()");
		}
	}

	public static void main(String[] args) {
		Shape[] shapes = { new Circle(), new Rhomboid(), new Square(), new Triangle() };
		for (Shape shape : shapes) {
			rotate(shape);
		}
	}
}