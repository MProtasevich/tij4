package generics.ex19;


import generics.ex13.Generators;

import java.util.ArrayList;
import java.util.Random;

import net.mindview.util.Generator;


class Item {
    private final int id;
    private String description;
    private String destination;
    private double price;

    public Item(int idNumber, String what, String whereTo, double price) {
        id = idNumber;
        description = what;
        destination = whereTo;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ", " + description + ", " + "$" + price + ", to: "
                + destination;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Item> generator = new Generator<Item>() {
        private Random rand = new Random();

        @Override
        public Item next() {
            return new Item(rand.nextInt(1000), "Very nice ... ",
                    "Destination: ...", Math.round(rand.nextDouble() * 1000.0));
        }
    };
}


class Shelf extends ArrayList<Item> {
    private static final long serialVersionUID = 1L;

    public Shelf(int nItems) {
        Generators.fill(this, Item.generator, nItems);
    }
}


class StorageArea extends ArrayList<Shelf> {
    private static final long serialVersionUID = 1L;

    public StorageArea(int nShelves, int nItems) {
        for(int i = 0; i < nShelves; i++)
            add(new Shelf(nItems));
    }
}


class Deck extends ArrayList<StorageArea> {
    private static final long serialVersionUID = 1L;

    public Deck(int nStorageAreas, int nShelves, int nItems) {
        for(int i = 0; i < nStorageAreas; i++)
            add(new StorageArea(nShelves, nItems));
    }
}


class CargoShip extends ArrayList<Deck> {
    private static final long serialVersionUID = 1L;

    public CargoShip(int nDecks, int nStorageAreas, int nShelves, int nItems) {
        for(int i = 0; i < nDecks; i++) {
            add(new Deck(nStorageAreas, nShelves, nItems));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Deck d : this) {
            for(StorageArea sa : d) {
                for(Shelf s : sa) {
                    for(Item i : s) {
                        result.append(i);
                        result.append('\n');
                    }
                }
            }
        }
        return result.toString();
    }
}


public class Ex19 {
    public static void main(String[] args) {
        System.out.println(new CargoShip(3, 4, 3, 10));
    }
}