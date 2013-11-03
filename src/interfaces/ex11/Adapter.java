package interfaces.ex11;


import interfaces.ex11.interfaceprocessor.Apply;
import interfaces.ex11.interfaceprocessor.Processor;
import interfaces.ex11.interfaceprocessor.StringMixer;


@SuppressWarnings("")
public class Adapter implements Processor {
    StringMixer stringMixer;

    public Adapter(StringMixer stringMixer) {
        this.stringMixer = stringMixer;
    }

    @Override
    public String name() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object process(Object input) {
        return stringMixer.process((String)input);
    }

    public static void main(String[] args) {
        String s = new String(args[0]);
        Apply.process(new Adapter(new StringMixer()), s);
    }
}