package generics.ex24;


import java.util.HashMap;
import java.util.Map;


interface Factory<T> {
    T create();
}


class Building {
}


class BuildingFactory implements Factory<Building> {
    @Override
    public Building create() {
        return new Building();
    }
}


class House extends Building {
}


class HouseFactory implements Factory<House> {
    @Override
    public House create() {
        return new House();
    }
}


public class ClassTypeCapture<T> {
    Class<?> kind;
    @SuppressWarnings("rawtypes")
    Map<String, Factory> map;

    public ClassTypeCapture(Class<?> kind,
            @SuppressWarnings("rawtypes") Map<String, Factory> map) {
        this.kind = kind;
        this.map = map;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Factory<T> factory) {
        map.put(typeName, factory);
    }

    public Object createNew(String typeName) throws InstantiationException,
            IllegalAccessException {
        if(map.containsKey(typeName)) {
            return map.get(typeName).create();
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(
                Building.class, new HashMap<String, Factory>());
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class,
                new HashMap<String, Factory>());
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}