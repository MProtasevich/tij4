package error_handling.ex13;


import error_handling.ex09.Exception1;
import error_handling.ex09.Exception2;
import error_handling.ex09.Exception3;


public class Ex13 {
    public static void f(int i) throws Exception1, Exception2, Exception3 {
        if(i == 1) {
            throw new Exception1("Exception1");
        } else if(i == 2) {
            throw new Exception2("Exception2");
        } else if(i == 3) {
            throw new Exception3("Exception3");
        } else if(i == 4) {
            throw new NullPointerException();
        }
    }

    public static void main(String[] args) {
        try {
            f(0);
            f(1);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally: f(1)");
        }
        try {
            f(2);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally: f(2)");
        }
        try {
            f(3);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally: f(3)");
        }
        try {
            f(4);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally: f(4)");
        }
    }
}