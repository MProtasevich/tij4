package type_information.ex09;


import static net.mindview.util.Print.print;

import java.lang.reflect.Field;


public class Ex09 {
    public static void printAncestors(Class<?> clazz) {
        Class<?> superClass = clazz.getSuperclass();
        print(clazz.getSimpleName());
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            print("\t" + field);
        }
        if(superClass != null) {
            printAncestors(superClass);
        }
    }

    public static void main(String[] args) {
        printAncestors(Integer.class);
    }
}