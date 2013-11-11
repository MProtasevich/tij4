package strings.ex19;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.TextFile;


public class Ex19 {
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.out.println("Usage: fileName");
            System.exit(0);
        }
        Pattern p = Pattern.compile("class \\w+\\s+");
        Pattern q = Pattern.compile("^(//|/\\*|\\*)");
        System.out.println("classes in " + args[0] + ":");
        int index = 0;
        Matcher m = p.matcher("");
        Matcher n = q.matcher("");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            n.reset(line);
            while(m.find() && !n.find())
                System.out.println(index++ + ": " + m.group());
        }
    }
}