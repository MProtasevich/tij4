package strings.ex17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;


public class Ex17 {
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.out.println("Usage: fileName");
            System.exit(0);
        }
        Pattern p = Pattern.compile("(//\\s.+)|(/\\*\\s+.+)|(\\*\\s+.+)");

        int index = 0;
        Matcher m = p.matcher("");
        System.out.println(args[0] + " comments: ");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " + m.group());
        }
    }
}