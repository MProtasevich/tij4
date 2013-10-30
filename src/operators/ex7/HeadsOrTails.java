package operators.ex7;

import java.util.Random;
import java.util.Scanner;

public class HeadsOrTails {
    public static final boolean HEADS = true, TAILS = false;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            boolean headsOrTails = rand.nextBoolean();
            if(headsOrTails == HEADS) {
                System.out.println("Heads!");
            } else if(headsOrTails == TAILS){
                System.out.println("Tails!");
            }

            System.out.println("Do you want to repeat? y/n");
            if("n".equals(scanner.next())) {
                break;
            }
        }

        scanner.close();
    }
}
