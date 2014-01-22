package type_information.ex03;

//: typeinfo/Shapes.java
import type_information.shapes.Rhomboid;
import type_information.shapes.Shape;

public class Shapes {
	public static void main(String[] args) {
		Rhomboid rhomboid = new Rhomboid();
		Shape shape = rhomboid;
		// ClassCastException will be thrown because Circle is not a Rhomboid
		// Circle circle = (Circle) shape;
	}
}