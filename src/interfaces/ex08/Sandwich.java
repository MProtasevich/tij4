//: polymorphism/Sandwich.java
// Order of constructor calls.
package interfaces.ex08;


class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}


class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}


class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}


class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}


class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}


class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}


interface FastFood {
    void cheeseburger();
    void fries();
    void softDrink();
}


@SuppressWarnings("unused")
public class Sandwich extends PortableLunch implements FastFood {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }

    @Override
    public void cheeseburger() {
        System.out.println("Sandwich.cheeseburger()");
    }

    @Override
    public void fries() {
        System.out.println("Sandwich.fries()");
    }

    @Override
    public void softDrink() {
        System.out.println("Sandwich.softDrink()");
    }
} /*
   * Output: Meal() Lunch() PortableLunch() Bread() Cheese() Lettuce()
   * Sandwich()
   */// :~