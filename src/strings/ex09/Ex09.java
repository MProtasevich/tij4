package strings.ex09;


import strings.ex08.Splitting;


public class Ex09 {
    public static void main(String[] args) {
        System.out.println(Splitting.knights.replaceAll("[aeiouy]", "_"));
    }
}