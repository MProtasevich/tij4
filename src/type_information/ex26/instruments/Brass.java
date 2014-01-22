package type_information.ex26.instruments;


public class Brass extends Wind {
    @Override
    public void clearSpitValve() {
        System.out.println("Brass spit valve cleared");
    }
}
