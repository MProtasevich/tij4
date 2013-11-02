package reusing_classes.ex09;


class Component1 {
    Component1() {
        System.out.println("Component1");
    }
}


class Component2 {
    Component2() {
        System.out.println("Component2");
    }
}


class Component3 {
    Component3() {
        System.out.println("Component3");
    }
}


public class Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    Root() {
        initComponents();
        System.out.println("Root");
    }

    protected void initComponents() {
        component1 = new Component1();
        component2 = new Component2();
        component3 = new Component3();
    }
}


class Stream extends Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    Stream() {
        initComponents();
        System.out.println("Stream");
    }
}