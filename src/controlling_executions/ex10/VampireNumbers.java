package controlling_executions.ex10;


public class VampireNumbers {
    public static final int RESTRICT = 100;
    public static final int[] CASES = { 18, 11, 12, 14 };

    public static void printVampireNumbers() {
        for(int k : CASES) {
            for(int i = k; i < RESTRICT; i += 9) {
                for(int j = i; j < RESTRICT; j += 9) {
                    if(i * j < RESTRICT * RESTRICT) {
                        checkVampire(i, j);
                    }
                }
            }
        }
    }

    public static boolean checkVampire(int x, int y) {
        return (x * y) % 9 == (x + y) % 9;
    }

    public static void main(String[] args) {
        printVampireNumbers();
    }
}
