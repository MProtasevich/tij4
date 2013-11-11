package strings.ex11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex11 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");
        Matcher matcher = pattern.matcher("Arline ate eight apples and one orange while Anita hadn’t any");
        while(matcher.find()) {
            System.out.println("Match \"" + matcher.group() + "\" at positions" + matcher.start() + "-" + matcher.end());
        }
    }
}