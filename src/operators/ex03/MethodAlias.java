package operators.ex03;


import operators.ex02.Alias;


public class MethodAlias {
    public static void aliasDemo(Alias alias) {
        alias.f = 3.0f;
    }

    public static void printAlias(Alias alias) {
        System.out.printf("alias.f = %f", alias.f);
    }

    public static void main(String[] args) {
        Alias alias = new Alias();
        alias.f = 1.0f;
        printAlias(alias);
        aliasDemo(alias);
        printAlias(alias);
    }
}