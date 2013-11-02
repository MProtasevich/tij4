package initialization_and_cleanup.ex16;


public class ArrayOfStrings {
    static final int NUM_OF_STRINGS = 10;
    String[] strs;

    public void initStrs() {
        strs = new String[NUM_OF_STRINGS];
        for(int i = 0; i < NUM_OF_STRINGS; ++i) {
            strs[i] = Integer.toString(i);
        }
        for(String item : strs) {
            System.out.println(item);
        }
    }
}