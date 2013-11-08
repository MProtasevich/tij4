package error_handling.ex18;


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
                } finally {
                    lm.dispose();
                }
            } finally {
                lm.g();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}