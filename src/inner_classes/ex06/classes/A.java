package inner_classes.ex06.classes;

import inner_classes.ex06.intrface.Interface;

public class A {
    protected class B implements Interface {
        public B() {}

        @Override
        public void f() {
            System.out.println("A.f()");
        }
    }
}