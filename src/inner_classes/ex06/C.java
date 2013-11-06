package inner_classes.ex06;

import inner_classes.ex06.classes.A;
import inner_classes.ex06.intrface.Interface;

public class C extends A {
    public Interface getInner() {
        return this.new B();
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.getInner());
    }
}