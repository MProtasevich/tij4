package type_information.ex20;

import static net.mindview.util.Print.print;

import java.lang.annotation.Documented;


public class ClassInfo {
    public static void printInfo(String classString) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(classString);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        print("class: " + clazz);
        print("clazz.getCanonicalName(): " + clazz.getCanonicalName());
        print("clazz.getClassLoader(): " + clazz.getClassLoader());
        print("clazz.getDeclaringClass(): " + clazz.getDeclaringClass());
        print("clazz.getEnclosingConstructor(): " + clazz.getEnclosingConstructor());
        print("clazz.getEnclosingMethod(): " + clazz.getEnclosingMethod());
        print("clazz.getEnumConstants(): " + clazz.getEnumConstants());
        print("clazz.getGenericSuperclass(): " + clazz.getGenericSuperclass());
        print("clazz.getModifiers(): " + clazz.getModifiers());
        print("clazz.getName(): " + clazz.getName());
        print("clazz.getPackage(): " + clazz.getPackage());
        print("clazz.getProtectionDomain(): " + clazz.getProtectionDomain());

        print("clazz.getSimpleName(): " + clazz.getSimpleName());
        print("clazz.getSuperclass(): " + clazz.getSuperclass());
        print("clazz.getTypeParameters(): " + clazz.getTypeParameters());
        print("clazz.isAnnotation(): " + clazz.isAnnotation());
        print("clazz.isAnnotationPresent(Documented.class): "
                + clazz.isAnnotationPresent(Documented.class));
        print("clazz.isAnonymousClass(): " + clazz.isAnonymousClass());
        print("clazz.isArray(): " + clazz.isArray());
        print("clazz.isAssignableFrom(ClassInfo.class): "
                + clazz.isAssignableFrom(ClassInfo.class));
        print("clazz.isAssignableFrom(Object.class): "
                + clazz.isAssignableFrom(Object.class));
        print("clazz.isEnum(): " + clazz.isEnum());
        print("clazz.isInstance(Object.class): " + clazz.isInstance(Object.class));
        print("clazz.isInterface(): " + clazz.isInterface());
        print("clazz.isLocalClass(): " + clazz.isLocalClass());
        print("clazz.isMemberClass(): " + clazz.isMemberClass());
        print("clazz.isPrimitive(): " + clazz.isPrimitive());
        print("clazz.isSynthetic(): " + clazz.isSynthetic());

        printAnnotations(clazz);
    }

    protected static void printAnnotations(Class<?> clazz) {
        print("clazz.getAnnotations(): ");
        printObjects(clazz.getAnnotations());
    }

    protected static void printClasses(Class<?> clazz) {
        print("clazz.getClasses(): ");
        printObjects(clazz.getClasses());
    }

    protected static void printConstructors(Class<?> clazz) {
        print("clazz.getConstructors(): ");
        printObjects(clazz.getConstructors());
    }

    protected static void printDeclairedAnnotations(Class<?> clazz) {
        print("clazz.getDeclaredAnnotations(): ");
        printObjects(clazz.getDeclaredAnnotations());
    }

    protected static void printDeclairedClasses(Class<?> clazz) {
        print("clazz.getDeclaredClasses(): ");
        printObjects(clazz.getDeclaredClasses());
    }
    
    protected static void printDeclairedConstructors(Class<?> clazz) {
        print("clazz.getDeclaredConstructors(): ");
        printObjects(clazz.getDeclaredConstructors());
    }

    protected static void printDeclairedFields(Class<?> clazz) {
        print("clazz.getDeclaredFields(): ");
        printObjects(clazz.getDeclaredFields());
    }

    protected static void printDeclairedMethods(Class<?> clazz) {
        print("clazz.getDeclaredMethods(): ");
        printObjects(clazz.getDeclaredMethods());
    }

    protected static void printGenericInterfaces(Class<?> clazz) {
        print("clazz.getGenericInterfaces(): ");
        printObjects(clazz.getGenericInterfaces());
    }

    protected void printInterfaces(Class<?> clazz) {
        print("clazz.getInterfaces(): ");
        printObjects(clazz.getInterfaces());
    }

    protected void printMethods(Class<?> clazz) {
        print("clazz.getMethods(): ");
        printObjects(clazz.getMethods());
    }

    protected void printSigners(Class<?> clazz) {
        print("clazz.getSigners(): ");
        if(clazz.getSigners() == null)
            print(clazz.getSigners());
        if(clazz.getSigners() != null) {
            print();
            if(clazz.getSigners().length == 0)
                print("none");
            if(clazz.getSigners().length > 0) {
                for(Object s : clazz.getSigners())
                    print(s);
            }
        }
    }

    protected static void printObjects(Object[] objects) {
        if(objects.length == 0) {
            print("none");
        }
        for(Object o : objects) {
            print(o);
        }
    }

    public static void main(String[] args) {
        if(args.length < 1) {
            print("Usage: name of class");
            System.exit(0);
        }

        printInfo(args[0]);
    }
}