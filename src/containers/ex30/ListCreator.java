package containers.ex30;


import java.util.List;

import net.mindview.util.RandomGenerator;


public interface ListCreator {
    static final RandomGenerator.Integer rg = new RandomGenerator.Integer();

    List<Integer> createCollection(int size);
}