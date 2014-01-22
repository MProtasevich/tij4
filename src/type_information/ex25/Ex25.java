package type_information.ex25;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import type_information.ex25.classes.A;


public class Ex25 {
    public static void main(String[] args) {
        A a = new A();
        Class<A> clazz = A.class;
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            method.setAccessible(true);
            try {
                method.invoke(a);
            } catch(IllegalAccessException e) {
                e.printStackTrace();
            } catch(IllegalArgumentException e) {
                e.printStackTrace();
            } catch(InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}