package polymorphism.ex15;


//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}


class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}


class RectangularGlyph extends Glyph {
    private int length;
    private int width;

    RectangularGlyph(int length, int width) {
        this.length = length;
        this.width = width;
        System.out.println("RectangularGlyph.RectangularGlyph(), length = "
                + length + ", width = " + width);
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), length = " + length
                + ", width = " + width);
    }
}


public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(2, 4);
    }
}