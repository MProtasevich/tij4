package reusing_classes.ex15;


import reusing_classes.ex15.pkg.Protected;


class ProtectedEx extends Protected {
    void g() {
        // can call f() in derived class
        super.f();
    }
}


public class Main {
    public static void main(String[] args) {
        Protected protected1 = new Protected();
        // protected1.f(); // Can't call this method because it's protected
        ProtectedEx protectedEx = new ProtectedEx();
        protectedEx.g();
    }
}