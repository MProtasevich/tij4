package operators.ex6;

import operators.ex5.Dog;

public class Exercise6 {
    public static void printCompare(Dog spot, Dog scruffy) {
        String spotName = spot.getName(),
                scruffyName = scruffy.getName();

        System.out.printf("%s == %s: %b\n%s.equals(%s): %b",
                spotName, scruffyName, spot == scruffy,
                spotName, scruffyName, spot.equals(scruffy));
    }
    public static void main(String[] args) {
        Dog spot = new Dog("spot", "Ruff!"),
            scruffy = new Dog("scruffy", "Wurf!");

        printCompare(spot, scruffy);
        scruffy = spot;
        printCompare(spot, scruffy);
    }
}
