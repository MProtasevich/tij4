package generics.ex37;


import generics.ex37.interfaces.Colored;
import generics.ex37.interfaces.SerialNumbered;
import generics.ex37.interfaces.TimeStamped;

import java.awt.Color;


class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Colored {
    private TimeStampedImp timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Colored colored = new ColoredImp();

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public Color getColor() {
        return colored.getColor();
    }
}


public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " "
                + mixin1.getSerialNumber() + " " + mixin1.getColor());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " "
                + mixin2.getSerialNumber() + " " + mixin2.getColor());
    }
}