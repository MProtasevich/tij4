//: interfaces/filters/Filter.java
package interfaces.ex11.filter;


public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
} // /:~