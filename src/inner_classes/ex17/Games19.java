package inner_classes.ex17;


import java.util.Random;


interface Games {
    void play();
}


interface GamesFactory {
    Games getGames();
}


class CoinToss implements Games {
    public static final int HEADS = 0, TAILS = 1;

    public static GamesFactory gamesFactory = new GamesFactory() {
        @Override
        public Games getGames() {
            return new CoinToss();
        }
    };

    Random rand = new Random();

    @Override
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


class DiceThrow implements Games {
    public static GamesFactory gamesFactory = new GamesFactory() {
        @Override
        public Games getGames() {
            return new DiceThrow();
        }
    };

    Random rand = new Random();

    @Override
    public void play() {
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }
}


public class Games19 {
    public static void playGame(GamesFactory factory) {
        Games g = factory.getGames();
        g.play();
    }

    public static void main(String[] args) {
        playGame(CoinToss.gamesFactory);
        playGame(DiceThrow.gamesFactory);
    }
}