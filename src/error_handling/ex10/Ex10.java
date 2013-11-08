package error_handling.ex10;

import error_handling.ex09.Exception1;
import error_handling.ex09.Exception2;


public class Ex10 {
    static void f() throws Exception2 {
        try {
            g();
        } catch (Exception1 e1) {
            throw new Exception2();
        }
    }
    
    static void g() throws Exception1 {
        throw new Exception1();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch(Exception2 e) {
            e.printStackTrace();
        }
    }
}