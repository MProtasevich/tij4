package concurrency.ex29.item;


public class Toast {
    public enum Status {
        DRY, JELLIED, PEANUTBUTTERED
    }

    private Status status = Status.DRY;
    private final int id;

    public Toast(int idn) {
        id = idn;
    }

    public void jelly() {
        status = Status.JELLIED;
    }

    public void peanutButter() {
        status = Status.PEANUTBUTTERED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}