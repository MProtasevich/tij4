package operators.ex02;


public class Aliasing {
    public static void printAliasing(Alias al1, Alias al2) {
        System.out.printf("al1.f = %f, al2.f = %f\n", al1.f, al2.f);
    }

    public static void main(String[] args) {
        Alias al1 = new Alias(), al2 = new Alias();
        al1.f = 1.0f;
        al2.f = 2.0f;
        printAliasing(al1, al2);
        al1 = al2;
        printAliasing(al1, al2);
        al1.f = 3.0f;
        printAliasing(al1, al2);
    }
}
