//: polymorphism/music3/Music3.java
// An extensible program.
package polymorphism.ex08;


import java.util.Random;

import polymorphism.ex06.Note;
import polymorphism.ex07.instruments.Brass;
import polymorphism.ex07.instruments.Instrument;
import polymorphism.ex07.instruments.Percussion;
import polymorphism.ex07.instruments.Stringed;
import polymorphism.ex07.instruments.Wind;
import polymorphism.ex07.instruments.Woodwind;


public class Music3 {
    public Instrument next() {
        Random rand = new Random();
        switch(rand.nextInt(6)) {
        case 0:
            return new Wind();
        case 1:
            return new Percussion();
        case 2:
            return new Stringed();
        case 3:
            return new Brass();
        case 4:
            return new Woodwind();
        case 5:
            return new Instrument();
        default:
            return new Instrument();
        }
    }

    // Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = { new Wind(), new Percussion(),
                new Stringed(), new Brass(), new Woodwind() };
        tuneAll(orchestra);
    }
}