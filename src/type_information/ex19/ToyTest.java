//: typeinfo/toys/ToyTest.java
// Testing class Class.
package type_information.ex19;


import type_information.ex01.HasBatteries;
import type_information.ex01.Shoots;
import type_information.ex01.Soft;
import type_information.ex01.Waterproof;


class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    // we can't instantiate object of this class because it hasn't default
    // constructor
    // Toy() {}
    Toy(int i) {}
}


class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Soft {
    FancyToy() {
        super(1);
    }
}


public class ToyTest {
    static void printInfo(Class<?> cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? ["
                + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        try {
            Toy.class.getDeclaredConstructor(int.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}