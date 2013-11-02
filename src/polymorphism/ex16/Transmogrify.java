package polymorphism.ex16;


class Starship {
    private AlertStatus alertStatus;

    public void changeAlertStatus(AlertStatus alertStatus) {
        this.alertStatus = alertStatus;
    }

    public void performAlert() {
        System.out.println(alertStatus.name());
    }
}


enum AlertStatus {
    GREEN, ORANGE, RED
}


public class Transmogrify {
    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.changeAlertStatus(AlertStatus.GREEN);
        starship.performAlert();
        starship.changeAlertStatus(AlertStatus.ORANGE);
        starship.performAlert();
    }
}