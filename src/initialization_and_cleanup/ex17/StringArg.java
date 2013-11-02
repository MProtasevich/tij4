package initialization_and_cleanup.ex17;


public class StringArg {
    public static final int OBJECTS_TO_CREATE = 10;

    public StringArg(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        StringArg[] array = new StringArg[OBJECTS_TO_CREATE];
    }
}