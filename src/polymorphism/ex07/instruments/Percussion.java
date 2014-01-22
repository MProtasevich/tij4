package polymorphism.ex07.instruments;


import polymorphism.ex06.Note;


public class Percussion extends Instrument {
    @Override
    public void play(Note n) {
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