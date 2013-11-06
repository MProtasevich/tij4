package holding_your_objects.ex32;


import typeinfo.pets.*;
import java.util.*;


class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}


public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random());
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();

        System.out.println("pets: ");
        for(Pet p : nc.pets)
            System.out.println(p + " ");

        System.out.println("\nreversed: ");
        for(Pet p : nc.reversed()) {
            System.out.println(p + " ");
        }

        System.out.println("\nrandomized: ");
        for(Pet p : nc.randomized()) {
            System.out.println(p + " ");
        }
    }
}