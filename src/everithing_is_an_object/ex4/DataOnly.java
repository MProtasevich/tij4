package everithing_is_an_object.ex4;


// Exercise 4: (1) Turn the DataOnly code fragments into a program that
// compiles and runs.
public class DataOnly {
    int i;
    double d;
    boolean b;

    {
        DataOnly data = new DataOnly();

        data.i = 47;
        data.d = 1.1;
        data.b = false;
    }
}
