//: typeinfo/pets/Dog.java
package typeinfo.pets;


public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Bark");
    }
}