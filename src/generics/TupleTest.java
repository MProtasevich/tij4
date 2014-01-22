//: generics/TupleTest.java
package generics;


import generics.ex03.SixTuple;
import net.mindview.util.*;


class Amphibian {
}


class Vehicle {
}


public class TupleTest {
    static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<String, Integer>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(new Amphibian(),
                "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(
                new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(
                new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    static SixTuple<Vehicle, Amphibian, String, Integer, Double, Float> m() {
        return new SixTuple<Vehicle, Amphibian, String, Integer, Double, Float>(
                new Vehicle(), new Amphibian(), "third", 4, 5.0, 6.0f);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // ttsi.first = "there"; // Compile error: final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());

        System.out.println(m());
    }
} /*
   * Output: (80% match) (hi, 47) (Amphibian@1f6a7b9, hi, 47) (Vehicle@35ce36,
   * Amphibian@757aef, hi, 47) (Vehicle@9cab16, Amphibian@1a46e30, hi, 47, 11.1)
   */// :~