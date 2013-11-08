package error_handling.ex28;


class MyException extends RuntimeException {
    private static final long serialVersionUID = -7109420757963479515L;

    public MyException(String string) {
        super(string);
    }
}


public class Ex28 {
    public static void main(String[] args) {
        throw new MyException("Message for exception");
    }
}