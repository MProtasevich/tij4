package controlling_executions.ex06;


public class TestRange {
    public static boolean test(int testVal, int begin, int end) {
        if(testVal >= begin && testVal <= end) {
            return true;
        }
        return false;
    }
}
