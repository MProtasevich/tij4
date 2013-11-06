package reusing_classes.ex20;


@SuppressWarnings("unused")
class WithFinals {
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private final void g() {
        System.out.println("WithFinals.g()");
    }
}


@SuppressWarnings("unused")
class OverridingPrivate extends WithFinals {
    // @Override // can't be placed here, because
    // WithFinals.f() declared as private (current class can't see this
    // method in ancestor) and final (method can't be overrided)
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private final void g() {
        System.out.println("OverridingPrivate.g()");
    }
}


class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    public final void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}


public class FinalOveridingIllusion {
}