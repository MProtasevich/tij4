package generics.ex01;


import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

import generics.Holder3;


public class Ex01 {
    public static void main(String[] args) {
        Holder3<Pet> petHolder3 = new Holder3<Pet>(new Pet());
        petHolder3.set(new Cat());
        System.out.println(petHolder3.get().toString());
        petHolder3.set(new Dog());
        System.out.println(petHolder3.get().toString());
    }
}
