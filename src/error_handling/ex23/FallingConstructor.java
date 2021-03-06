package error_handling.ex23;

class Dispose {
    public Dispose() throws Exception {}

    void dispose() {
        System.out.println("Dispose.dispose()");
    }
}

public class FallingConstructor {
    Dispose dispose1, dispose2;

    public FallingConstructor() throws Exception {}

    FallingConstructor(boolean fail) throws Exception {
        try {
            dispose1 = new Dispose();
            try {
                if(fail) {
                    throw new Exception();
                }
                try {
                    dispose2 = new Dispose();
                } catch(Exception e) {
                    System.out.println("dispose2 init");
                }
            } catch(Exception e) {
                System.out.println("inner exception");
                dispose2.dispose();
            }
        } catch(Exception e) {
            System.out.println("dispose1 init");
            dispose1.dispose();
        }
    }

    public static void main(String[] args) {
        try {
            new FallingConstructor(true);
        } catch(Exception e) {
            System.out.println("main()");
            e.printStackTrace();
        } finally {}
    }
}