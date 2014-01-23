package generics.ex40;


//: generics/Apply.java
// {main: ApplyTesimport static net.mindview.util.Print.print;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import typeinfo.pets.Dog;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;


public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq,
            Method f, Object... args) {
        try {
            for(T t : seq) {
                f.invoke(t, args);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}


class FilledList<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;

    public FilledList(Class<? extends T> type, int size) {
        try {
            for(int i = 0; i < size; i++) {
                add(type.newInstance());
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}


class ApplyTest {
    public static void main(String[] args) throws Exception {
        List<Pet> pets = Pets.arrayList(10);
        System.out.println("Random pets: " + pets);
        Apply.apply(pets, Pet.class.getMethod("speak"));
        Apply.apply(new FilledList<Pet>(Dog.class, 5), Pet.class.getMethod("speak"));
    }
}