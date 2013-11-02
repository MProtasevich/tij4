package controlling_executions.ex03;


import java.util.Random;


public class InfLoop {
    public static void printInLoop() {
        Random rand = new Random();
        while(true) {
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
        printInLoop();
    }
}