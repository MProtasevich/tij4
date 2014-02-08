package concurrency.ex29.queue;


import java.util.concurrent.LinkedBlockingQueue;

import concurrency.ex29.item.Toast;


public class ToastQueue extends LinkedBlockingQueue<Toast> {
    private static final long serialVersionUID = 1L;
}