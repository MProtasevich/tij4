package everithing_is_an_object.ex8;

import everithing_is_an_object.ex7.StaticTest;

public class Exercise8 {
    public static final String SHOW_STATIC = "st1.i = %d, st2.i = %d, " +
                                               "StaticTest.i = %d";
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.printf(SHOW_STATIC, st1.i, st2.i, StaticTest.i);
        st1.i++;
        System.out.printf(SHOW_STATIC, st1.i, st2.i, StaticTest.i);
        st2.i++;
        System.out.printf(SHOW_STATIC, st1.i, st2.i, StaticTest.i);
        StaticTest.i++;
        System.out.printf(SHOW_STATIC, st1.i, st2.i, StaticTest.i);
    }
}
