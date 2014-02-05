package concurrency.ex02;


public class Ex02 {
    public static void main(String[] args) {
        int numOfTimes = 5, num = 10;
        for(int i = 0; i < numOfTimes; ++i) {
            new Thread(new FibonacciThread(num)).start();
        }
    }
}