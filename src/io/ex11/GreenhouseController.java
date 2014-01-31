package io.ex11;


import inner_classes.ex24.GreenhouseControls;
import inner_classes.ex24.controller.Event;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


interface EventFactory {
    Event getEvent(GreenhouseControls gc, Long time);
}


class BellFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new Bell(time);
    }
}


class LightOnFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new LightOn(time);
    }
}


class LightOffFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new LightOff(time);
    }
}


class WaterOnFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new WaterOn(time);
    }
}


class WaterOffFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new WaterOff(time);
    }
}


class ThermostatDayFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new ThermostatDay(time);
    }
}


class ThermostatNightFactory implements EventFactory {
    @Override
    public Event getEvent(GreenhouseControls gc, Long time) {
        return gc.new ThermostatNight(time);
    }
}


public class GreenhouseController {
    // To read events from text file and add to HashMap<String,Long>:
    public static Map<String, Long> readEvents(String filename)
            throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        Map<String, Long> map = new HashMap<String, Long>();
        while((s = in.readLine()) != null) {
            String[] sa = s.split("[()]");
            map.put(sa[0], new Long(sa[1]));
        }
        in.close();
        return map;
    }

    // To build Event objects from Map.Entry objects:
    static Event makeEvent(GreenhouseControls gc, Map.Entry<String, Long> me) {
        String key = me.getKey();
        Long value = me.getValue();
        if(key.equals("Bell")) {
            return new BellFactory().getEvent(gc, value);
        } else if(key.equals("LightOn")) {
            return new LightOnFactory().getEvent(gc, value);
        } else if(key.equals("LightOff")) {
            return new LightOffFactory().getEvent(gc, value);
        } else if(key.equals("WaterOn")) {
            return new WaterOnFactory().getEvent(gc, value);
        } else if(key.equals("WaterOff")) {
            return new WaterOffFactory().getEvent(gc, value);
        } else if(key.equals("ThermostatDay")) {
            return new ThermostatDayFactory().getEvent(gc, value);
        } else if(key.equals("ThermostatNight")) {
            return new ThermostatNightFactory().getEvent(gc, value);
        }
        return null;
    }
}