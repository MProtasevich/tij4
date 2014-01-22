package polymorphism.ex07.instruments;


import polymorphism.ex06.Note;


public class Wind extends Instrument {
    @Override
    public void play(Note n) {
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