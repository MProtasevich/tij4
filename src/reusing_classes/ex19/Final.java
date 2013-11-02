package reusing_classes.ex19;


public class Final {
    final int staticValue;

    Final() {
        this(1);
    }

    Final(int i) {
        // if remove this statement, then we get an error
        // "final field may not have been initialized"
        staticValue = i;
        // staticValue = i; can't change assigned value again
    }
}