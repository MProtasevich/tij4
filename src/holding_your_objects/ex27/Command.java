package holding_your_objects.ex27;

import java.util.LinkedList;
import java.util.Queue;

public class Command {
    public static final int NUM = 5;
    String string;

    public Command(String string) {
        this.string = string;
    }

    void operation() {
        System.out.println(string);
    }

    public static void main(String[] args) {
        Queue<Command> queue = FillQueue.fillQueue();
        Caller.callOperation(queue);
    }
}

class FillQueue {
    static Queue<Command> fillQueue() {
        Queue<Command> queue = new LinkedList<Command>();

        for(int i = 0; i < Command.NUM; i++) {
            queue.add(new Command(Integer.toString(i)));
        }
        return queue;
    }
}

class Caller {
    static void callOperation(Queue<Command> queue) {
        for(Command command : queue) {
            command.operation();
        }
    }
}