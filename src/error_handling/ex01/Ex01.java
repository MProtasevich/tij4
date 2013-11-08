package error_handling.ex01;

public class Ex01 {
    public static void main(String[] args) {
        try {
            throw new Exception("Test exception");
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            System.out.println("finnaly");
        }
    }
}