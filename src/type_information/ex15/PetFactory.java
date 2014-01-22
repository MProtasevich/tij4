package type_information.ex15;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.EgyptianMau;
import typeinfo.pets.GerbilEx11;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;


class PetFactory {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Class<? extends Pet>> petFactories = new ArrayList<Class<? extends Pet>>();
    static {
        petFactories.add(Pet.class);
        petFactories.add(Cat.class);
        petFactories.add(Cymric.class);
        petFactories.add(Dog.class);
        petFactories.add(EgyptianMau.class);
        petFactories.add(GerbilEx11.class);
        petFactories.add(Hamster.class);
        petFactories.add(Manx.class);
        petFactories.add(Mouse.class);
        petFactories.add(Mutt.class);
        petFactories.add(Pug.class);
        petFactories.add(Rat.class);
        petFactories.add(Rodent.class);
    }
    private static Random rand = new Random();

    public static Pet createRandom() {
        int n = rand.nextInt(petFactories.size());
        try {
            return petFactories.get(n).newInstance();
        } catch(InstantiationException ie) {
            ie.printStackTrace();
        } catch(IllegalAccessException iae) {
            iae.printStackTrace();
        }
        return null;
    }
}