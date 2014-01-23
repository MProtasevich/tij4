package generics.ex26;


public class Ex26 {
    public static void main(String[] args) {
        Number[] numbers = new Integer[2];
        numbers[0] = new Integer(0);
        numbers[1] = new Integer(1);

        try { // runtime ArrayStoreException:
            numbers[1] = new Double(3.4);
        } catch(Exception e) {
            System.out.println(e);
        }

        for(Number n : numbers) {
            System.out.println(n);
        }
        // compile errors: incompatible types:
        // Integer[] ints = numbers;
        // for(Integer n : numbers) {
        //     System.out.println(n);
        // }
        // even though runtime type is Integer:
        for(Number n : numbers) {
            System.out.println(n.getClass().getSimpleName());
        }
    }
}