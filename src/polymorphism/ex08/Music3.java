//: polymorphism/music3/Music3.java
// An extensible program.
package polymorphism.ex08;


import java.util.Random;

import polymorphism.ex06.Note;


class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play() " + n);
    }

    @Override
    public String toString() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}


class Wind extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}


class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}


class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}


class Brass extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}


class Woodwind extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    @Override
    public String toString() {
        return "Woodwind";
    }
}


class Guitar extends Stringed {
    @Override
    void play(Note n) {
        System.out.println("Guitar.play()" + n);
    }

    @Override
    public String toString() {
        return "Guitar";
    }

    @Override
    void adjust() {
        System.out.println("Adjust Guitar");
    }
}


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
            return new Guitar();
        default:
            return new Instrument();
        }
    }

    // Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
        // ...
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
} /*
   * Output: Wind.play() MIDDLE_C Percussion.play() MIDDLE_C Stringed.play()
   * MIDDLE_C Brass.play() MIDDLE_C Woodwind.play() MIDDLE_C
   */// :~