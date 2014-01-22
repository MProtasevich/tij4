package generics.ex15;


import generics.ex03.SixTuple;
import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.*;


class Amphibian {
}


class Vehicle {
}


public class Ex15 {
    static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        // unchecked
        TwoTuple<String, Integer> ttsi2 = f2();

        System.out.println(ttsi);
        System.out.println(ttsi2);
        // ttsi.first = "there"; // Compile error: final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
} /*
   * Output: (80% match) (hi, 47) (Amphibian@1f6a7b9, hi, 47) (Vehicle@35ce36,
   * Amphibian@757aef, hi, 47) (Vehicle@9cab16, Amphibian@1a46e30, hi, 47, 11.1)
   */// :~