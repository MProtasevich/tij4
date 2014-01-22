package type_information.ex21;


//: typeinfo/SimpleProxyDemo.java
import static net.mindview.util.Print.*;


class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        long start, end;
        start = System.currentTimeMillis();
        proxied.doSomething();
        end = System.currentTimeMillis();
        print("Time (in nanosec):" + (end - start));
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        long start, end;
        start = System.currentTimeMillis();
        proxied.somethingElse(arg);
        end = System.currentTimeMillis();
        print("Time (in nanosec):" + (end - start));
    }
}


public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}