package interfaces.ex17;


public class Main implements Interface {
    public static void main(String[] args) {
        System.out.println(Interface.i);
        // Interface.i++; //compilation error
    }
}