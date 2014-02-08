package concurrency.ex29.item;


public class Sandwich {
    private Toast top, bottom;
    private final int id;

    public Sandwich(Toast top, Toast bottom, int id) {
        this.top = top;
        this.bottom = bottom;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Toast getTop() {
        return top;
    }

    public Toast getBottom() {
        return bottom;
    }

    @Override
    public String toString() {
        return "Sandwich " + id + ": top: " + top + " and bottom: " + bottom;
    }
}