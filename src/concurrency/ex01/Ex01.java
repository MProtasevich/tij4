package concurrency.ex01;


public class Ex01 {
    public static void main(String[] args) {
        for(int i = 0; i < 3; ++i) {
            new Thread(new ThreadA()).start();
        }
    }
}