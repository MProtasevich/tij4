//: interfaces/filters/Waveform.java
package interfaces.ex11.filter;


public class Waveform {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Waveform " + id;
    }
} // /:~