package io.ex11;


import inner_classes.ex24.GreenhouseControls;
import inner_classes.ex24.controller.Event;

import java.io.IOException;
import java.util.Map;


public class Ex11 {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        try {
            // Read text and convert lines to map entries:
            Map<String, Long> map = GreenhouseController
                    .readEvents("src/io/ex11/events.txt");
            Event[] eventList = new Event[map.size()];
            int i = 0;

            // Make events from map and add to Event array:
            for(Map.Entry<String, Long> me : map.entrySet()) {
                eventList[i++] = GreenhouseController.makeEvent(gc, me);
            }

            gc.addEvent(gc.new Restart(2000, eventList));

            if(args.length == 1) {
                gc.addEvent(new GreenhouseControls.Terminate(new Integer(
                        args[0])));
            } else {
                System.out.println("Usage: enter integer terminate time");
                System.exit(0);
            } 

            gc.run();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}