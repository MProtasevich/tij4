package everithing_is_an_object.ex09;


public class Autoboxing {
    public static void main(String[] args) {
        boolean boolPrim = false;
        char charPrim = 'c';
        byte bytePrimitive = 1;
        short shortPrim = 2;
        int intPrim = 4;
        long longPrim = 8l;
        float floatPrim = 16.0f;
        double doublePrim = 64.0;
        Boolean boolClass = boolPrim;
        System.out.printf("boolean = %b, Boolean = %b\n", boolPrim, boolClass);
        Character charClass = charPrim;
        System.out.printf("char = %c, Character = %c\n", charPrim, charClass);
        Byte byteClass = bytePrimitive;
        System.out.printf("byte = %d, Byte = %d\n", bytePrimitive, byteClass);
        Short shortClass = shortPrim;
        System.out.printf("short = %d, Short = %d\n", shortPrim, shortClass);
        Integer intClass = intPrim;
        System.out.printf("int = %d, Integer = %d\n", intPrim, intClass);
        Long longClass = longPrim;
        System.out.printf("long = %d, Long = %d\n", longPrim, longClass);
        Float floatClass = floatPrim;
        System.out.printf("float = %f, Float = %f\n", floatPrim, floatClass);
        Double doubleClass = doublePrim;
        System.out
                .printf("double = %f, Double = %f\n", doublePrim, doubleClass);
    }
}