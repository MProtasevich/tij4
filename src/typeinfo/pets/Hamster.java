//: typeinfo/pets/Hamster.java
package typeinfo.pets;


public class Hamster extends Rodent {
    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Ksi");
    }
}