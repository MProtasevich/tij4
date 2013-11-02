package access_control.ex08.connection;


public class Connection {
    private static int COUNT = 0;
    private int index = COUNT;

    Connection() {
        ++COUNT;
        ++index;
    }
}
