package generics.ex37;


import generics.ex37.interfaces.Colored;

import java.awt.Color;
import java.util.Random;


public class ColoredImp implements Colored {
    private Color color;

    public ColoredImp() {
        Random rand = new Random();
        int red = rand.nextInt(255), green = rand.nextInt(255), blue = rand
                .nextInt(255);
        color = new Color(red, green, blue);
    }

    @Override
    public Color getColor() {
        return color;
    }
}