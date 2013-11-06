package inner_classes.ex11;

// class is not visible
// import inner_classes.ex11.Outer.Inner;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.getInner().f();
        // ((Inner)outer.getInner()).f();
    }
}