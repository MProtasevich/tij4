package initialization_and_cleanup.ex18;


import initialization_and_cleanup.ex17.StringArg;


public class StringArg2 {
    public static void main(String[] args) {
        StringArg[] array = new StringArg[StringArg.OBJECTS_TO_CREATE];
        for(int i = 0; i < StringArg.OBJECTS_TO_CREATE; ++i) {
            array[i] = new StringArg("12");
        }
    }
}