package interfaces.ex19;


import java.util.Random;


@SuppressWarnings("")
interface Games {
    void play();
}


interface GamesFactory {
    Games getGames();
}


class CoinToss implements Games {
    public static final int HEADS = 0, TAILS = 1;

    Random rand = new Random();

    public void play() {
        System.out.println("Toss Coin: ");
        switch(rand.nextInt(2)) {
        case HEADS:
            System.out.println("Heads");
            return;
        case TAILS:
            System.out.println("Tails");
            return;
        }
    }
}


class CoinTossFactory implements GamesFactory {
    public Games getGames() {
        return new CoinToss();
    }
}


class DiceThrow implements Games {
    Random rand = new Random();

    public void play() {
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }
}


class DiceThrowFactory implements GamesFactory {
    public Games getGames() {
        return new DiceThrow();
    }
}


public class Games19 {
    public static void playGame(GamesFactory factory) {
        Games g = factory.getGames();
        g.play();
    }

    public static void main(String[] args) {
        playGame(new CoinTossFactory());
        playGame(new DiceThrowFactory());
    }
}