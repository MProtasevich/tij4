package reusing_classes.ex11;


public class Delegation {
}


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


class Detergent {
    private Cleanser cleanser = new Cleanser();

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        cleanser.scrub();
    }

    public void foam() {
        cleanser.append(" foam()");
    }
    /*
     * public static void main(String[] args) { }
     */
}