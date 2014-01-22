package type_information.ex26.instruments;


public class Woodwind extends Wind {
    @Override
    public void clearSpitValve() {
        System.out.println("Woodwind spit valve cleared");
    }
}
