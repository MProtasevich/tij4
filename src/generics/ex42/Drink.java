package generics.ex42;


public class Drink {
    private String drinkName = "";

    public Drink() {
        this("");
    }

    public Drink(String name) {
        set(name);
    }

    public void set(String name) {
        drinkName = name;
    }

    public String get() {
        return drinkName;
    }

    public void eat() {
        drinkName = "";
    }

    @Override
    public String toString() {
        return "Drink: " + drinkName;
    }
}