package enums.ex08;


import java.util.Iterator;

import net.mindview.util.Enums;


public class Mail {
    // The NO's lower the probability of random selection:
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannability {
        UNSCANNABLE, YES1, YES2,
    }

    enum Readability {
        ILLEGIBLE, YES1, YES2, YES3, YES4
    }

    enum ForwardAddress {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Address {
        INCORRECT, OK1, OK2, OK3, OK4, OK5
    }

    enum ReturnAddress {
        MISSING, OK1, OK2, OK3, OK4, OK5
    }

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    ForwardAddress forwardAddress;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() + ", General Delivery: " + generalDelivery
                + ", Address Scannability: " + scannability
                + ", Address Readability: " + readability
                + ", ForwardAddress: " + forwardAddress + ", Address Address: "
                + address + ", Return address: " + returnAddress;
    }

    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() { // not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}