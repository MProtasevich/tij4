package arrays.ex19;


public class IntClass {
    private int i;

    public IntClass(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IntClass) {
            return i == ((IntClass)obj).i;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    public int getI() {
        return i;
    }
}