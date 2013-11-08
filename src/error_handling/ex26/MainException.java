package error_handling.ex26;


import java.io.*;


public class MainException {
    public static void main(String[] args) throws Exception {
        // FileNotFoundException
        FileInputStream file = new FileInputStream("File.java");
        file.close();
    }
}