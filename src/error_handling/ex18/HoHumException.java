package error_handling.ex18;


public class HoHumException extends Exception {
    private static final long serialVersionUID = 1223826116414765131L;

    @Override
    public String toString() {
        return "A trivial exception";
    }
}