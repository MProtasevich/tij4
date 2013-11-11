package strings.ex07;

public class Ex07 {
    public static void main(String[] args) {
        String pattern = "^[A-Z].*[\\.]$";
        System.out.println("A.".matches(pattern));
        System.out.println("Ab.".matches(pattern));
        System.out.println("aA..".matches(pattern));
        System.out.println("ad Af.".matches(pattern));
    }
}