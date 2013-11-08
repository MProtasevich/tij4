package error_handling.ex08;

import error_handling.ex04.MyException;


public class Ex08 {
    public static void f() throws MyException {
        // "Unhandled Exception type" without throws
        throw new MyException("message");
    }

    public static void main(String[] args) {
        try {
            Ex08.f();
        } catch(MyException e) {
            e.printMessage();
        }
    }
}