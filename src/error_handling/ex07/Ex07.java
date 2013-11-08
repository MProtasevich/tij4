package error_handling.ex07;


import java.io.StringWriter;
import java.util.logging.Logger;


public class Ex07 {
    private static Logger logger = Logger.getLogger("Exception");

    static void log(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace();
        logger.severe(sw.toString());
    }

    public static void main(String[] args) {
        try {
            int[] array = { 1, 2 };
            ++array[5];
        } catch(ArrayIndexOutOfBoundsException aioobe) {
            aioobe.printStackTrace();
            log(aioobe);
        }
    }
}