package generics.ex02;

public class Holder<T> {
    private Object[] objects;
    private static final int NUM_OF_OBJECTS = 3;
    
    public Holder(T... a) {
        if(a.length == NUM_OF_OBJECTS) {
            objects = a;
        } else if(a.length > NUM_OF_OBJECTS) {
            objects = new Object[NUM_OF_OBJECTS];
            for(int i = 0; i < NUM_OF_OBJECTS; ++i) {
                objects[i] = a[i];
            }
        } else if(a.length < NUM_OF_OBJECTS) {
            objects = new Object[NUM_OF_OBJECTS];
            for(int i = 0; i < a.length; ++i) {
                objects[i] = a[i];
            }

            for(int i = a.length; i < NUM_OF_OBJECTS; ++i) {
                try {
                    objects[i] = a.getClass().newInstance();
                } catch(InstantiationException e) {
                    e.printStackTrace();
                } catch(IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setObject(T a, int index) {
        if(index > objects.length || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }

        objects[index] = a;
    }

    @SuppressWarnings("unchecked")
    public T getObject(int index) {
        return (T)objects[index];
    }
}