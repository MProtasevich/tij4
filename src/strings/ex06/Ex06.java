package strings.ex06;


public class Ex06 {
    private int i = 1;
    private long l = 2L;
    private float f = 3.4f;
    private double d = 5.6;

    public Ex06() {}

    public Ex06(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    @Override
    public String toString() {
        return String.format("i = %d\nl = %d\nf = %.16g\nd = %.16g\n", i, l, f,
                d);
    }

    public static void main(String[] args) {
        Ex06 ex06 = new Ex06();
        System.out.println(ex06);
        ex06 = new Ex06(Integer.MAX_VALUE, Long.MIN_VALUE, .0123456789f, .0123456789);
        System.out.println(ex06);
    }
}