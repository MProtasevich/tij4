package io.ex30;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Line extends Shape {
    private static final long serialVersionUID = -6666632877661389545L;
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os)
            throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os)
            throws IOException {
        color = os.readInt();
    }

    public Line(int xVal, int yVal, int dim) {
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