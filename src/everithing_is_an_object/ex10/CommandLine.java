package everithing_is_an_object.ex10;


public class CommandLine {
    public static final int NUM_OF_ARGS = 3;

    public static void main(String[] args) {
        if(args.length < NUM_OF_ARGS) {
            System.out.println("Not enough arguments");
            System.exit(1);
        }
        for(int i = 0; i < NUM_OF_ARGS; ++i) {
            System.out.printf("args[%d] = %s", i, args[i]);
        }
    }
}
