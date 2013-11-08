package error_handling.ex19;


import error_handling.ex18.HoHumException;
import error_handling.ex18.ThirdException;
import error_handling.ex18.VeryImportantException;


public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void g() throws ThirdException {
        throw new ThirdException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                try {
                    lm.f();
                } catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    lm.dispose();
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lm.g();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}