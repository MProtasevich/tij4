package concurrency.ex34;


import java.util.concurrent.*;
import java.util.*;
import net.mindview.util.*;


public class ExchangerDemo {
    static int size = 10;
    static int delay = 5; // Seconds

    public static void main(String[] args) throws Exception {
        if(args.length > 0) {
            size = new Integer(args[0]);
        } else if(args.length > 1) {
            delay = new Integer(args[1]);
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Obj>> xc = new Exchanger<List<Obj>>();
        List<Obj> producerList = new CopyOnWriteArrayList<Obj>(), consumerList = new CopyOnWriteArrayList<Obj>();
        exec.execute(new ExchangerProducer<Obj>(xc, BasicGenerator
                .create(Obj.class), producerList));
        exec.execute(new ExchangerConsumer<Obj>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}