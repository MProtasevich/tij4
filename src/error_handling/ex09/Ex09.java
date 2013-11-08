package error_handling.ex09;


public class Ex09 {
    public static void f(int i) throws Exception1, Exception2, Exception3 {
        if(i == 1) {
            throw new Exception1("Exception1");
        } else if(i == 2) {
            throw new Exception2("Exception2");
        } else if(i == 3) {
            throw new Exception3("Exception3");
        }
    }

    public static void main(String[] args) {
        try {
            f(0);
            f(1);
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            f(2);
        } catch(Exception e) {
            e.printStackTrace();
        }
        try {
            f(3);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}