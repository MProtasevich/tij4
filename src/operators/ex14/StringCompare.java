package operators.ex14;


public class StringCompare {
    public static void stringCompare(String str1, String str2) {
        System.out.printf("%s == %s: %b", str1, str2, str1 == str2);
        System.out.printf("%s != %s: %b", str1, str2, str1 != str2);
        System.out.printf("%s.equals(%s): %b", str1, str2, str1.equals(str2));
    }

    public static void main(String[] args) {
        String str1 = "str1", str2 = "str2", str3 = "Str3", str31 = "Str3";
        stringCompare(str1, str2);
        stringCompare(str2, str3);
        stringCompare(str3, str31);
        stringCompare(str1, str1);
    }
}