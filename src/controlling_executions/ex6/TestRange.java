package controlling_executions.ex6;


public class TestRange {
    public static boolean test(int testVal, int begin, int end) {
        if(testVal >= begin && testVal <= end) {
            return true;
        }
        return false;
    }
}
