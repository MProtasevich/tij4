package holding_your_objects.ex13;


//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
import inner_classes.ex24.controller.Event;

import java.util.LinkedList;
import java.util.ListIterator;


public class GreenhouseController {
    private LinkedList<Event> eventList = new LinkedList<Event>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        LinkedList<Event> eventListCopy = new LinkedList<Event>(eventList);
        ListIterator<Event> it = eventListCopy.listIterator();

        while(it.hasNext()) {
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
} /*
   * Output: Bing! Thermostat on night setting Light is on Light is off
   * Greenhouse water is on Greenhouse water is off Thermostat on day setting
   * Restarting system Terminating
   */// :~
