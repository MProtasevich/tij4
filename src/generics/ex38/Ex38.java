package generics.ex38;


class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}


class Decorator extends Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void set(String val) {
        coffee.set(val);
    }

    @Override
    public String get() {
        return coffee.get();
    }
}


class SteamedMilk extends Decorator {
    private final String steamedMilk = "steamedMilk";

    public SteamedMilk(Coffee coffee) {
        super(coffee);
    }

    public String getSteamedMilk() {
        return steamedMilk;
    }
}


class Foam extends Decorator {
    private final String foam = "foam";

    public Foam(Coffee coffee) {
        super(coffee);
    }

    public String getFoam() {
        return foam;
    }
}


class Chocolate extends Decorator {
    private final String chocolate = "chocolate";

    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    public String getChocolate() {
        return chocolate;
    }
}


class Caramel extends Decorator {
    private final String caramel = "caramel";

    public Caramel(Coffee coffee) {
        super(coffee);
    }

    public String getCaramel() {
        return caramel;
    }
}


class WhippedCream extends Decorator {
    private final String whippedCream = "whippedCream";

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    public String getWhippedCream() {
        return whippedCream;
    }
}


public class Ex38 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SteamedMilk sm = new SteamedMilk(new Coffee());
        SteamedMilk sm2 = new SteamedMilk(new Foam(new Coffee()));
        Chocolate c = new Chocolate(new Coffee());
        WhippedCream wc = new WhippedCream(new Caramel(new Chocolate(new Foam(
                new SteamedMilk(new Coffee())))));
    }
}