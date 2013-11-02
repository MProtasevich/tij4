package operators.ex08;


public class HexOctal {
    public static void main(String[] args) {
        long l1 = 0x1fl;
        long l2 = 0x2fl;
        System.out.printf("l1 = %l, l2 = %l", l1, l2);
        System.out.printf("l1_b = %s, l2 = %s", Long.toBinaryString(l1),
                Long.toBinaryString(l2));
    }
}