package initialization_and_cleanup.ex20;


public class MainVarargs {
    public static void main(String... args) {
        for(String arg : args) {
            System.out.println(arg);
        }
    }
}
