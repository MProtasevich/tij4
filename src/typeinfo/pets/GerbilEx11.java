package typeinfo.pets;


public class GerbilEx11 extends Rodent {
    public GerbilEx11() {
        super();
    }

    public GerbilEx11(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Phi");
    }
}