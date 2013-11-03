package access_control.ex09;


import access_control.ex09.access.local.PackagedClass;

public class AccessLocal {
    public static void main(String[] args) {
        /*PackagedClass pc = */new PackagedClass();
    }
}
// Compiler error because: PackagedClass in not public, so no access outside of
// package. Moving Foreign to local would allow package access to PackagedClass.