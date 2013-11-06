package holding_your_objects.ex29;

import java.util.PriorityQueue;

public class ObjectEx extends Object {
    public static void main(String[] args) {
        PriorityQueue<ObjectEx> queue = new PriorityQueue<ObjectEx>();
        queue.add(new ObjectEx());
        // ClassCastException: ObjectEx cannot be cast to Comparable
        queue.add(new ObjectEx());
    }
}