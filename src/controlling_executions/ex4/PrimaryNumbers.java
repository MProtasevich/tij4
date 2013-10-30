package controlling_executions.ex4;


import java.lang.Math;


public class PrimaryNumbers {
    public static void printPrimaryNumbers(int lessThan) {
        if(lessThan < 2) {
            System.out.println("No primary numbers less than 2");
        }
        System.out.println(2);
        for(int i = 3; i < lessThan; i += 2) {
            int sq = (int)Math.round(Math.sqrt(i));
            for(int j = 3; j < sq; j += 2) {
                if(i % j == 0) {
                    break;
                } else {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        printPrimaryNumbers(100);
    }
}