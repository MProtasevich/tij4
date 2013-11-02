package reusing_classes.ex02;


class Cleanser {
    private String s = "Cleanser";

    public void append(String s) {
        this.s += s;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }
    /*
     * public static void main(String[] args) {
     * 
     * }
     */
}


public class Detergent extends Cleanser {
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }
    /*
     * public static void main(String[] args) { }
     */
}


class DetergentEx extends Detergent {
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void sterilize() {
        append(" sterilize()");
    }
}