package strings.ex20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex20 {
    private final long l;
    private final float f;
    private final double d;

    public Ex20(String string) {
        Matcher m = Pattern.compile("\\d+[lL]?$").matcher(string);
        if(m.find()) {
            l = Long.parseLong(m.group());
        } else {
            l = 0L;
        }
        String doubleStr = "(([0-9]*\\.[0-9]+)([eE][+-]?[0-9]+)?|[0-9]+\\3)$";
        m = Pattern.compile(doubleStr).matcher(string);
        if(m.find()) {
            d = Double.parseDouble(m.group());
        } else {
            d = 0.0;
        }
        String floatStr = doubleStr.replaceFirst("\\$", "[fF]");
        m = Pattern.compile(floatStr).matcher(string);
        if(m.find()) {
            f = Float.parseFloat(m.group());
        } else {
            f = 0.0f;
        }
    }

    @Override
    public String toString() {
        return "l = " + l + "\nf = " + f + "\nd = " + d;
    }

    public static void main(String[] args) {
        System.out.println(new Ex20("1l 15.0f .1"));
    }
}