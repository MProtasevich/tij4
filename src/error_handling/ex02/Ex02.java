package error_handling.ex02;

public class Ex02 {

    @SuppressWarnings("null")
    public static void main(String[] args) {
        try {
            Object object = null;
            object.toString();
        } catch(NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}