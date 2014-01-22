package type_information.ex25.classes;


public class A {
    private void privat() {
        System.out.println("privat()");
    }

    protected void protect() {
        System.out.println("protect()");
    }

    void packageAccess() {
        System.out.println("packageAccess()");
    }
}