package error_handling.ex11;

import error_handling.ex09.Exception1;


public class Ex11 {
    static void f() {
        try {
            g();
        } catch(Exception1 e1) {
            throw new RuntimeException();
        }
    }

    static void g() throws Exception1 {
        throw new Exception1();
    }

    public static void main(String[] args) {
        f();
    }
}