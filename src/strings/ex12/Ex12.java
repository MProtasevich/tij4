package strings.ex12;


//: strings/Groups.java
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex12 {
    public static final String POEM = "Twas bRillig, and the slithy toves\n"
            + "Did gyre and gimble in the wabe.\n"
            + "All mimsy were the borogoves,\n"
            + "And the mome raths outgrabe.\n\n"
            + "Beware the Jabberwock, my son,\n"
            + "The jaws that bite, the claws that catch.\n"
            + "Beware the Jubjub bird, and shun\n"
            + "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(\\b[a-z]\\w+\\b)(?!.*\\1\\b)").matcher(POEM);
        while(m.find()) {
            System.out.println(m.group());
        }
    }
}