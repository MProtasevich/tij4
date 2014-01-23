package generics.ex42;


//: generics/Functional.java
import static net.mindview.util.Print.print;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


// Different types of function objects:
interface Combiner<T> {
    T combine(T x, T y);
}


interface UnaryFunction<R, T> {
    R function(T x);
}


interface Collector<T> extends UnaryFunction<T, T> {
    T result();
}


public class Functional {
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if(it.hasNext()) {
            T result = it.next();

            while(it.hasNext()) {
                result = combiner.combine(result, it.next());
            }

            return result;
        }

        return null;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for(T t : seq) {
            func.function(t);
        }
        return func;
    }

    static class MealMaker implements Combiner<Food> {
        @Override
        public Food combine(Food f1, Food f2) {
            return new Food(f1.get() + " " + f2.get());
        }
    }

    static class DrinkMaker implements Combiner<Drink> {
        @Override
        public Drink combine(Drink d1, Drink d2) {
            return new Drink(d1.get() + " " + d2.get());
        }
    }

    static class CookedMeal implements Collector<Food> {
        private Food f = new Food("");

        @Override
        public Food function(Food x) {
            f = new Food(f.get() + " " + x.get());
            return f;
        }

        @Override
        public Food result() {
            return new Food("cooked " + f.get());
        }
    }

    public static void main(String[] args) {
        List<Food> lf = Arrays.asList(new Food("bread"), new Food("ham"),
                new Food("cheese"));
        Food meal = reduce(lf, new MealMaker());
        print(meal);
        List<Drink> ld = Arrays.asList(new Drink("water"), new Drink(
                "orange juice"), new Drink("lemon"));
        Drink drink = reduce(ld, new DrinkMaker());
        print(drink);
        print(forEach(lf, new CookedMeal()).result());
    }
}