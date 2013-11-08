package error_handling.ex29;


//: exceptions/StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.
class BaseballException extends RuntimeException {
    private static final long serialVersionUID = -170999015404220769L;
}


class Foul extends BaseballException {
    private static final long serialVersionUID = 1260184365459893627L;
}


class Strike extends BaseballException {
    private static final long serialVersionUID = 5717840969628134076L;
}


abstract class Inning {
    public Inning() throws BaseballException {}

    public void event() throws BaseballException {}

    public abstract void atBat() throws Strike, Foul;

    public void walk() {} // Throws no checked exceptions
}


class StormException extends RuntimeException {
    private static final long serialVersionUID = 7374731042260671324L;
}


class RainedOut extends StormException {
    private static final long serialVersionUID = -1647927599265175276L;
}


class PopFoul extends Foul {
    private static final long serialVersionUID = -2956268743109294135L;
}


interface Storm {
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}


public class StormyInning extends Inning implements Storm {
    // OK to add new exceptions for constructors, but you
    // must deal with the base constructor exceptions:
    public StormyInning() throws RainedOut, BaseballException {}

    public StormyInning(String s) throws Foul, BaseballException {}

    // If the method doesn't already exist in the
    // base class, the exception is OK:
    public void rainHard() throws RainedOut {}

    // You can choose to not throw any exceptions,
    // even if the base version does:
    public void event() {}

    // Overridden methods can throw inherited exceptions:
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        StormyInning si = new StormyInning();
        si.atBat();
        // Strike not thrown in derived version.

        // What happens if you upcast?
        Inning i = new StormyInning();
        i.atBat();
        // You must catch the exceptions from the
        // base-class version of the method:
    }
}