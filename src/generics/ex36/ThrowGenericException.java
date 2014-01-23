package generics.ex36;


//: generics/ThrowGenericException.java
import java.util.*;


interface Processor<T, E1 extends Exception, E2 extends Exception> {
    void process(List<T> resultCollector) throws E1, E2;
}


class ProcessRunner<T, E1 extends Exception, E2 extends Exception> extends
        ArrayList<Processor<T, E1, E2>> {
    private static final long serialVersionUID = 1L;

    List<T> processAll() throws E1, E2 {
        List<T> resultCollector = new ArrayList<T>();
        for(Processor<T, E1, E2> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}


class Failure1 extends Exception {
    private static final long serialVersionUID = 1L;
}


class Processor1 implements Processor<String, Failure1, Failure2> {
    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if(count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }
        if(count < 0) {
            throw new Failure1();
        }
    }
}


class Failure2 extends Exception {
    private static final long serialVersionUID = 1L;
}


class Processor2 implements Processor<Integer, Failure1, Failure2> {
    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if(count < 0) {
            throw new Failure2();
        }
    }
}


public class ThrowGenericException {
    public static void main(String[] args) {
        int numOfAttempts = 3;
        ProcessRunner<String, Failure1, Failure2> runner = new ProcessRunner<String, Failure1, Failure2>();
        for(int i = 0; i < numOfAttempts + 1; i++) {
            runner.add(new Processor1());
        }
        try {
            System.out.println(runner.processAll());
        } catch(Failure1 e) {
            System.out.println(e);
        } catch(Failure2 e) {
            System.out.println(e);
        }
        ProcessRunner<Integer, Failure1, Failure2> runner2 = new ProcessRunner<Integer, Failure1, Failure2>();
        for(int i = 0; i < numOfAttempts; i++) {
            runner2.add(new Processor2());
        }
        try {
            System.out.println(runner2.processAll());
        } catch(Failure1 e) {
            System.out.println(e);
        } catch(Failure2 e) {
            System.out.println(e);
        }
    }
}