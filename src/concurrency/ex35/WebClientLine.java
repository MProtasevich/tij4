package concurrency.ex35;


import java.util.concurrent.ArrayBlockingQueue;


public class WebClientLine extends ArrayBlockingQueue<WebClient> {
    private static final long serialVersionUID = 1L;

    public WebClientLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if(this.size() == 0) {
            return "[Empty]";
        }

        StringBuilder result = new StringBuilder();
        for(WebClient webClient : this) {
            result.append(webClient);
        }

        return result.toString();
    }
}
