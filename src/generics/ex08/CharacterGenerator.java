//: generics/coffee/CoffeeGenerator.java
package generics.ex08;


import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;


public class CharacterGenerator implements Generator<StoryCharacter>,
        Iterable<StoryCharacter> {
    private Class<?>[] types = { Batman.class, Carnage.class, SpiderMan.class,
            Venom.class };
    private static Random rand = new Random(47);

    public CharacterGenerator() {}

    // For iteration:
    private int size = 0;

    public CharacterGenerator(int sz) {
        size = sz;
    }

    @Override
    public StoryCharacter next() {
        try {
            return (StoryCharacter)types[rand.nextInt(types.length)]
                    .newInstance();
            // Report programmer errors at run time:
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<StoryCharacter> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacter next() {
            count--;
            return CharacterGenerator.this.next();
        }

        @Override
        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CharacterGenerator gen = new CharacterGenerator();
        for(int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for(StoryCharacter c : new CharacterGenerator(5)) {
            System.out.println(c);
        }
    }
}