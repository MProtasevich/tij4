package type_information.ex22;


//: typeinfo/SimpleDynamicProxy.java
import java.lang.reflect.*;

import static net.mindview.util.Print.print;
import type_information.ex21.Interface;
import type_information.ex21.RealObject;


class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.println("**** proxy: " + proxy.getClass() + ", method: "
                + method + ", args: " + args);

        if(args != null) {
            for(Object arg : args) {
                System.out.println("  " + arg);
            }
        }

        long start, end;
        start = System.currentTimeMillis();
        Object result = method.invoke(proxied, args);
        end = System.currentTimeMillis();
        print("Time: " + (end - start));

        return result;
    }
}


public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] { Interface.class }, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}