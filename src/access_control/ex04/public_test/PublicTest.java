package access_control.ex04.public_test;


import access_control.ex04.PackageTest;


public class PublicTest {
    public static void main(String[] args) {
        // ProtectedTest.print(); // No access
        PackageTest.printProtected();
    }
}