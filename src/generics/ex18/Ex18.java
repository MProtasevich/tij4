package generics.ex18;


import generics.ex13.Generators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import net.mindview.util.Generator;


class BigFish {
    private static long counter = 0;
    private final long id = ++counter;

    private BigFish() {}

    @Override
    public String toString() {
        return "BigFish" + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}


class LittleFish {
    private static long counter = 0;
    private final long id = ++counter;

    private LittleFish() {}

    @Override
    public String toString() {
        return "LittleFish" + id;
    }

    public static Generator<LittleFish> generator = new Generator<LittleFish>() {
        @Override
        public LittleFish next() {
            return new LittleFish();
        }
    };
}


class Ocean {
    public static void eat(BigFish bf, LittleFish lf) {
        System.out.println(bf + " eats " + lf);
    }
}


public class Ex18 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<BigFish> hunters = new ArrayList<BigFish>();
        Generators.fill(hunters, BigFish.generator(), 3);
        Queue<LittleFish> school = new LinkedList<LittleFish>();
        Generators.fill(school, LittleFish.generator, 15);
        for(LittleFish f : school) {
            Ocean.eat(hunters.get(rand.nextInt(hunters.size())), f);
        }
    }
}