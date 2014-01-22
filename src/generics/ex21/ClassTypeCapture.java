package generics.ex21;


import java.util.Map;


class Building {
}


class House extends Building {
}


public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> map;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public Object createNew(String typeName) throws InstantiationException,
            IllegalAccessException {
        if(map.containsKey(typeName)) {
            return map.get(typeName).newInstance();
        }
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(
                Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}