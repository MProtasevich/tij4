package concurrency.ex35;


public class WebClient {
    private final int serviceTime;

    public WebClient(int tm) {
        serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}