package interfaces.ex04;

abstract class AbstractStatic {
}

public class AbstractEx extends AbstractStatic {
    void print() {
        System.out.println(this.getClass().getSimpleName());
    }
    
    static void printClass(AbstractEx as) {
        ((AbstractEx) as).print();
    }

    static void printClass(AbstractStatic2 as) {
        as.print();
    }

    public static void main(String[] args) {
        AbstractEx abstractEx = new AbstractEx();
        AbstractEx.printClass(abstractEx);
        
        AbstractEx2 abstractEx2 = new AbstractEx2();
        AbstractEx.printClass(abstractEx2);
    }
}

abstract class AbstractStatic2 {
    abstract void print();
}

class AbstractEx2 extends AbstractStatic2 {
    @Override
    void print() {
        System.out.println(this.getClass().getSimpleName());
    }
}