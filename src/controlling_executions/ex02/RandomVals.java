package controlling_executions.ex02;


import java.util.Random;


public class RandomVals {
    public static final int NUMBERS_TO_COMPARE = 25;

    public static void printRandom() {
        Random rand = new Random();
        for(int i = 0; i < NUMBERS_TO_COMPARE; ++i) {
            int firstVal = rand.nextInt(), secondVal = rand.nextInt();
            if(firstVal < secondVal) {
                System.out.println(firstVal + " < " + secondVal);
            } else if(firstVal > secondVal) {
                System.out.println(firstVal + " > " + secondVal);
            } else {
                System.out.println(firstVal + " == " + secondVal);
            }
        }
    }

    public static void main(String[] args) {
        printRandom();
    }
}