package type_information.ex16;

// typeinfo/RegisteredCoffeeFactories16.java
// TIJ4 Chapter Typeinfo, Exercise 16, page 586
// Modify the Coffee hierarchy in the Generics chapter to use Registered Factories.
import generics.coffee.Americano;
import generics.coffee.Breve;
import generics.coffee.Cappuccino;
import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
class CoffeeFactory {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    static List<Class<? extends Coffee>> coffeeFactories =
            new ArrayList<Class<? extends Coffee>>();
    static {
        coffeeFactories.add(Latte.class);
        coffeeFactories.add(Mocha.class);
        coffeeFactories.add(Cappuccino.class);
        coffeeFactories.add(Americano.class);
        coffeeFactories.add(Breve.class);
    }
    private static Random rand = new Random();

    public static Coffee createRandom() {
        int n = rand.nextInt(coffeeFactories.size());
        try {
            return coffeeFactories.get(n).newInstance();
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
 
public class Ex16 {
    public static void main(String[] args) {
        for(int i = 0; i < 15; i++) {
            System.out.println(CoffeeFactory.createRandom());
        }
    }
}