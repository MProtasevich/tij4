package io.ex30;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Ex30 {
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<Shape>();
        // Make some shapes:
        for(int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        // Set all the static colors to GREEN
        for(int i = 0; i < 10; i++) {
            ((Shape)shapes.get(i)).setColor(Shape.GREEN);
        }
        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                "CADState.out"));
        Circle.serializeStaticState(out);
        Square.serializeStaticState(out);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        // Display the shapes:
        System.out.println(shapes);
    }
}