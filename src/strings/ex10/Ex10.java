package strings.ex10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10 {
    private static final String PARAM = "Java now has regular expressions";
    private static final String[] PATTERNS =
        { PARAM, "^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?",
          "s*", "s+", "s{4}", "S{1}", "s{0,3}" };
    
    public static void main(String[] args) {
        String[] patterns; 
        if(args.length < 2) {
            patterns = PATTERNS;
        } else {
            patterns = args;
        }

        String argString = patterns[0];
        System.out.println("Input: " + argString);
        for(int i = 1; i < patterns.length; ++i) {
            System.out.println("RegExp: " + patterns[i]);
            Pattern pattern = Pattern.compile(patterns[i]);
            Matcher matcher = pattern.matcher(argString);
            while(matcher.find()) {
                System.out.println("Match \"" + matcher.group() +
                        "\" at positions " + matcher.start() +
                        (matcher.end() - matcher.start() < 2 ? "" :
                        "-" + (matcher.end() - 1)));
            }
        }
    }
}