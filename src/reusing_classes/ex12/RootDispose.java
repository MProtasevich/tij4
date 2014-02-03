package reusing_classes.ex12;


class Component1 {
    Component1() {
        System.out.println("Component1");
    }

    void dispose() {
        System.out.println("Component1.dispose()");
    }
}


class Component2 {
    Component2() {
        System.out.println("Component2");
    }

    void dispose() {
        System.out.println("Component2.dispose()");
    }
}


class Component3 {
    Component3() {
        System.out.println("Component3");
    }

    void dispose() {
        System.out.println("Component3.dispose()");
    }
}


public class RootDispose {
    Component1 componentRoot1;
    Component2 componentRoot2;
    Component3 componentRoot3;

    RootDispose() {
        initComponents();
        System.out.println("Root");
    }

    protected void initComponents() {
        componentRoot1 = new Component1();
        componentRoot2 = new Component2();
        componentRoot3 = new Component3();
    }

    void dispose() {
        componentRoot1.dispose();
        componentRoot2.dispose();
        componentRoot3.dispose();
        System.out.println("Root.dispose()");
    }
}


class Stream extends RootDispose {
    Component1 componentStream1;
    Component2 componentStream2;
    Component3 componentStream3;

    Stream() {
        initComponents();
        System.out.println("Stream");
    }

    @Override
    void dispose() {
        componentStream1.dispose();
        componentStream2.dispose();
        componentStream3.dispose();
        super.dispose();
        System.out.println("Stream dispose");
    }
}