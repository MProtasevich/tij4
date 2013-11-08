package error_handling.ex18;


public class VeryImportantException extends Exception {
    private static final long serialVersionUID = -8730301080409503253L;

    @Override
    public String toString() {
        return "A very important exception!";
    }
}