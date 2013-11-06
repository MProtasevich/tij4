package inner_classes.ex14;


//: interfaces/HorrorShow.java
// Extending an interface with inheritance.
interface Monster {
    void menace();
}


interface DangerousMonster extends Monster {
    void destroy();
}


interface Lethal {
    void kill();
}


class DragonZilla implements DangerousMonster {
    public void menace() {}

    public void destroy() {}
}


interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}


class VeryBadVampire implements Vampire {
    public void menace() {}

    public void destroy() {}

    public void kill() {}

    public void drinkBlood() {}
}


public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public DangerousMonster createMonster() {
        return new DangerousMonster() {
            @Override
            public void menace() {
                System.out.println("DangerousMonster.menace()");
            }

            @Override
            public void destroy() {
                System.out.println("DangerousMonster.destroy()");
            }
        };
    }

    public Vampire createVampire() {
        return new Vampire() {
            @Override
            public void kill() {
                System.out.println("Vampire.kill()");
            }
            
            @Override
            public void menace() {
                System.out.println("Vampire.menace()");
            }
            
            @Override
            public void destroy() {
                System.out.println("Vampire.destroy()");
            }
            
            @Override
            public void drinkBlood() {
                System.out.println("Vampire.drinkBlood()");
            }
        };
    }

    public static void main(String[] args) {
        HorrorShow horrorShow = new HorrorShow();
        HorrorShow.u(horrorShow.createVampire());
        HorrorShow.v(horrorShow.createMonster());
    }
} // /:~
