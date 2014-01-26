package arrays.ex13;


import net.mindview.util.CountingGenerator;


public class Ex13 {
    public static String createString(int numOfChars) {
        CountingGenerator.Character cg = new CountingGenerator.Character();
        char[] chars = new char[numOfChars];

        for(int i = 0; i < numOfChars; ++i) {
            chars[i] = cg.next();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(createString(5));
    }
}