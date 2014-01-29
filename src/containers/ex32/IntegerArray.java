package containers.ex32;


import java.util.Arrays;


public class IntegerArray {
    private Integer[] array;
    private int pointer;

    public IntegerArray() {
        this(2);
    }

    public IntegerArray(int size) {
        array = new Integer[size];
    }

    public void add(Integer integer) {
        if(pointer >= array.length) {
            int size = array.length;
            Integer[] newArray = new Integer[size * 2];
            for(int i = 0; i < size; ++i) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[pointer++] = integer;
    }

    public Integer get(int index) {
        if(index >= pointer) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    public void incrementAll() {
        for(int i = 0; i < pointer; ++i) {
            ++array[i];
        }
    }

    public int size() {
        return pointer;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}