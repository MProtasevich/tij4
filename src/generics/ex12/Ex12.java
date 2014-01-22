package generics.ex12;

import java.util.List;
import java.util.Map;

import net.mindview.util.New;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;


public class Ex12 {
    static void f(Map<Person, List<Pet>> petPeople) {}

    public static void main(String[] args) {
        f(New.<Person, List<Pet>> map());
    }
}