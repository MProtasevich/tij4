package error_handling.ex06;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


class Exception1 extends Exception {
    private static final long serialVersionUID = 2601753528745028296L;
    private static final Logger logger = Logger.getLogger("Exception");

    Exception1() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }
}


class Exception2 extends Exception {
    private static final long serialVersionUID = 2601753528745028296L;
    private static final Logger logger = Logger.getLogger("Exception");

    Exception2() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }
}


public class Ex06 {
    public static void main(String[] args) {
        try {
            throw new Exception1();
        } catch(Exception e) {}
        try {
            throw new Exception2();
        } catch(Exception e) {}
    }
}