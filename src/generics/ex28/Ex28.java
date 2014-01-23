package generics.ex28;


import typeinfo.pets.Cat;
import typeinfo.pets.Pet;


public class Ex28 {
    static <T> void cvArgs(Generic1<? super T> g1, T t) {
        g1.set(t);
    }

    static <T> T cvArgs(Generic2<? extends T> g2) {
        return g2.get();
    }

    public static void main(String[] args) {
        cvArgs(new Generic1<Pet>(), new Cat("Meow"));
        cvArgs(new Generic2<Pet>());
    }
}