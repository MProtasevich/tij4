package generics.ex37;


import generics.ex37.interfaces.TimeStamped;

import java.util.Date;


public class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}