package error_handling.ex04;


public class Ex04 {
    public static void main(String[] args) {
        try {
            throw new MyException("Message for exception");
        } catch(MyException e) {
            e.printMessage();
        }
    }
}