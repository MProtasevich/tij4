package containers.ex40;


import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;


public class RandGen extends RandomGenerator {
    public static class StringClass implements
            Generator<containers.ex40.StringClass> {
        @Override
        public containers.ex40.StringClass next() {
            RandomGenerator.String rg = new RandomGenerator.String();
            return new containers.ex40.StringClass(rg.next(), rg.next());
        }
    }
}