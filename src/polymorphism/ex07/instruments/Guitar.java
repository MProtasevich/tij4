package polymorphism.ex07.instruments;


import polymorphism.ex06.Note;


class Guitar extends Stringed {
    @Override
    public void play(Note n) {
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