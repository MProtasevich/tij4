package operators.ex05;


public class Dog {
    private String name;
    private String says;

    public Dog(String name, String says) {
        this.setName(name);
        this.setSays(name);
    }

    public void printDog() {
        System.out.printf("%s says %s", getName(), getSays());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }
}
