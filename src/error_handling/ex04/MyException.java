package error_handling.ex04;


public class MyException extends Exception {
    private static final long serialVersionUID = -4052691633484022900L;
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.err.println(message);
    }
}