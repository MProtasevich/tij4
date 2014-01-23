//: typeinfo/pets/Rat.java
package typeinfo.pets;


public class Rat extends Rodent {
    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Phi-phi");
    }
}