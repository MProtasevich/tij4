package error_handling.ex30;


import java.io.FileNotFoundException;
import java.io.IOException;


//: exceptions/Human.java
// Catching exception hierarchies.
class Annoyance extends RuntimeException {
    private static final long serialVersionUID = 1355020409554819820L;
}


class Sneeze extends Annoyance {
    private static final long serialVersionUID = -6876665038286723153L;
}


class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch(type) {
            case 0:
                throw new FileNotFoundException();
            case 1:
                throw new IOException();
            case 2:
                throw new RuntimeException("Where am I?");
            default:
                return;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}


public class Human {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        for(int i = 0; i < 3; i++) {
            try {
                if(i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new RuntimeException();
                }
            } catch(RuntimeException re) {
                try {
                    throw re.getCause();
                } catch(Sneeze e) {
                    System.out.println("Sneeze: " + e);
                } catch(Annoyance e) {
                    System.out.println("Annoyance: " + e);
                } catch(Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}