package containers.ex31;

import java.util.Arrays;


public class StringArray {
    private String[] array;
    private int pointer;

    public StringArray() {
        this(2);
    }

    public StringArray(int size) {
        array = new String[size];
    }

    public void add(String string) {
        if(pointer >= array.length) {
            int size = array.length;
            String[] newArray = new String[size * 2];
            for(int i = 0; i < size; ++i) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[pointer++] = string;
    }

    public String get(int index) {
        if(index >= pointer) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}