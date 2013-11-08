package error_handling.ex22;


public class FallingConstructor {
    FallingConstructor(boolean fail) throws Exception {
        if(fail) {
            throw new Exception();
        }
    }

    public static void main(String[] args) {
        try {
            new FallingConstructor(true);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {}
    }
}