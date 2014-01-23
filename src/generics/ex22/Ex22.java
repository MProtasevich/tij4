package generics.ex22;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Ex22 {
    public static final <T> Object create(Class<T> clazz, Object... args)
            throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {

        Class<?>[] argClasses = new Class<?>[args.length];

        for(int i = 0; i < args.length; ++i) {
            argClasses[i] = args[i].getClass();
        }

        Constructor<T> constructor = clazz.getConstructor(argClasses);
        return constructor.newInstance(args);
    }

    public static void main(String[] args) {
        try {
            System.out.println(create(Integer.class, "2"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}