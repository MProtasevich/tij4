package initialization_and_cleanup.ex03;


public class DefaultConstructor {
    public DefaultConstructor() {
        System.out.println("Message.");
    }

    public DefaultConstructor(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        /* DefaultConstructor defaultConstructor = */new DefaultConstructor();
        /* DefaultConstructor constructor = */new DefaultConstructor("Message");
    }
}