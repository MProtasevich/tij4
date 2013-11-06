package inner_classes.ex02;

public class HoldString {
    String string;

    public HoldString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}