package generics.ex37;


import generics.ex37.interfaces.SerialNumbered;


public class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}