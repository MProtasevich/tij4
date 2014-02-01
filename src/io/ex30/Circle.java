package io.ex30;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Circle extends Shape {
    private static final long serialVersionUID = 9060110785620962400L;
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os)
            throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os)
            throws IOException {
        color = os.readInt();
    }

    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}