package initialization_and_cleanup.ex12;


class Tank {
    boolean isFull = false;

    Tank() {
        this(false);
    }

    Tank(boolean isFull) {
        this.isFull = isFull;
    }

    void isFull() {
        System.out.println("Tank is " + (isFull ? "full" : "empty"));
    }

    void empty() {
        isFull = false;
    }

    @Override
    protected void finalize() {
        if(!isFull) {
            System.out.println("Error: Tank not empty");
        }
        // Normally, you'll also do this:
        // super.finalize(); // Call the base-class version
    }

    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank(true);
        // Proper cleanup: empty tank before going home
        tank2.empty();
        // Drop the reference, forget to cleanup:
        new Tank(true);
        System.out.println("Check tanks:");
        System.out.println("tank1: ");
        tank1.isFull();
        System.out.println("tank2: ");
        tank2.isFull();
        System.out.println("first forced gc():");
        System.gc();
        // Force finalization on exit but using method
        // deprecated since JDK 1.1:
        System.out.println("try deprecated runFinalization():");
        System.runFinalization();
        System.out.println("last forced gc():");
        System.gc();
    }
}