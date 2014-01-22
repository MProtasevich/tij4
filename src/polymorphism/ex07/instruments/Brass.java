package polymorphism.ex07.instruments;


import polymorphism.ex06.Note;


public class Brass extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}