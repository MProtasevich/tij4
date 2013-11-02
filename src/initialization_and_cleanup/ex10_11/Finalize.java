package initialization_and_cleanup.ex10_11;


public class Finalize {
    @Override
    public void finalize() {
        System.out.println("Finalize.");
    }

    public static void main(String[] main) {
        new Finalize();
        // Ex11
        System.runFinalization();;
    }
}