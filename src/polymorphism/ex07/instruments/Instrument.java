package polymorphism.ex07.instruments;


import polymorphism.ex06.Note;


public class Instrument {
    public void play(Note n) {
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