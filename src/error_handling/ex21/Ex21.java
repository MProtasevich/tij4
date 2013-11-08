package error_handling.ex21;

class A {
    A() throws Exception {
        throw new Exception();
    }
}
class B extends A {
    B() throws Exception {
        super();
        // compilation error
        /*try {
            super();
        } catch(Exception e) {
            e.printStackTrace();
        }*/
    }
}