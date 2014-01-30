package containers.ex42;


import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;


public class RandGen extends RandomGenerator {
    public static class StringClass implements
            Generator<containers.ex42.StringClass> {
        @Override
        public containers.ex42.StringClass next() {
            RandomGenerator.String rg = new RandomGenerator.String();
            return new containers.ex42.StringClass(rg.next(), rg.next());
        }
    }
}