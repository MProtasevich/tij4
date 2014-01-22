package type_information.ex08;


import static net.mindview.util.Print.print;


public class Ex08 {
    public static void printAncestors(Class<?> clazz) {
        Class<?> superClass = clazz.getSuperclass();
        print(clazz.getSimpleName());
        if(superClass != null) {
            printAncestors(superClass);
        }
        /*
         * Class<?>[] interfaces = clazz.getInterfaces(); for(Class<?> interfce
         * : interfaces) { print(interfce.getSimpleName());
         * printAncestors(interfce); }
         */
    }

    public static void main(String[] args) {
        printAncestors(Integer.class);
    }
}