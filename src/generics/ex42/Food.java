package generics.ex42;


public class Food {
    private String foodName = "";

    public Food() {
        this("");
    }

    public Food(String name) {
        set(name);
    }

    public void set(String name) {
        foodName = name;
    }

    public String get() {
        return foodName;
    }

    public void eat() {
        foodName = "";
    }

    @Override
    public String toString() {
        return "Food: " + foodName;
    }
}