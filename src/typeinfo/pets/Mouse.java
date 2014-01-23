//: typeinfo/pets/Mouse.java
package typeinfo.pets;


public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    @Override
    public void speak() {
        System.out.println("Ksi-ksi");
    }
}