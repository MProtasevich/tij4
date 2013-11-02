package reusing_classes.ex16;


class Amphibian {
    protected void swim() {
        System.out.println("Amphibian swim");
    }

    void eat() {
        System.out.println("Amphibian eat");
    }

    static void grow(Amphibian a) {
        System.out.println("Amphibian grow");
        a.eat();
    }
}


public class Frog extends Amphibian {
    public static void main(String[] args) {
        Frog f = new Frog();
        // call base-class methods:
        f.swim();
        f.eat();
        // upcast Frog to Amphibian argument:
        Amphibian.grow(f);
    }
}