package reusing_classes.ex10;


class Component1 {
    Component1(int i) {
        System.out.println("Component1: " + i);
    }
}


class Component2 {
    Component2(int i) {
        System.out.println("Component2: " + i);
    }
}


class Component3 {
    Component3(int i) {
        System.out.println("Component3: " + i);
    }
}


public class Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    Root(int i) {
        initComponents(i);
        System.out.println("Root: " + i);
    }

    protected void initComponents(int i) {
        component1 = new Component1(i);
        component2 = new Component2(i);
        component3 = new Component3(i);
    }
}


class Stream extends Root {
    Component1 component1;
    Component2 component2;
    Component3 component3;

    Stream(int i) {
        super(i);
        initComponents(i);
        System.out.println("Stream: " + i);
    }
}