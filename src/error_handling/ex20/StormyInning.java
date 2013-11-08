package error_handling.ex20;


class BaseballException extends Exception {
    private static final long serialVersionUID = 1480799888495323711L;
}


class Foul extends BaseballException {
    private static final long serialVersionUID = 8926499811663555302L;
}


class Strike extends BaseballException {
    private static final long serialVersionUID = 9188155139618805288L;
}


abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {} // Throws no checked exceptions
    public void f() throws UmpireArgument {}
}


class StormException extends Exception {
    private static final long serialVersionUID = -8366196643752156458L;
}


class RainedOut extends StormException {
    private static final long serialVersionUID = 3689027443629805087L;
}


class PopFoul extends Foul {
    private static final long serialVersionUID = -7047033771058070924L;
}


class UmpireArgument extends Exception {
    private static final long serialVersionUID = 177336849918814770L;
    
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

    // Regular methods must conform to base class:
    // ! void walk() throws PopFoul {} //Compile error
    // Interface CANNOT add exceptions to existing
    // methods from the base class:
    // ! public void event() throws RainedOut {}
    // If the method doesn't already exist in the
    // base class, the exception is OK:
    @Override
    public void rainHard() throws RainedOut {}

    // You can choose to not throw any exceptions,
    // even if the base version does:
    @Override
    public void event() {}

    // Overridden methods can throw inherited exceptions:
    @Override
    public void atBat() throws PopFoul {}
    
    @Override
    public void f() throws UmpireArgument {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
            si.f();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        } catch(UmpireArgument e) {
            System.out.println("UnimpireArgument");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the
            // base-class version of the method:
        } catch(Strike e) {
            System.out.println("Strike");
        } catch(Foul e) {
            System.out.println("Foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}