package everithing_is_an_object.ex5;

// Exercise 5: (1) Modify the previous exercise so that the values of the
// data in DataOnly are assigned to and printed in main().
public class DataOnly {
    int i;
    double d;
    boolean b;

    public static void main(String[] args) {
        DataOnly data = new DataOnly();

        data.i = 47;
        data.d = 1.1;
        data.b = false;

        System.out.printf("data.i = %d\n" +
                          "data.d = %.2f\n" +
                          "data.b = %b", data.i, data.d, data.b);
    }
}
