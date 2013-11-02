package reusing_classes.ex21;


class Ancestor {
    final void print() {
        System.out.println("Ancestor");
    }
}


public class Final extends Ancestor {
    // @Override // we can't override final methods
    // final void print() {
    // System.out.println("Final");
    // }
}
