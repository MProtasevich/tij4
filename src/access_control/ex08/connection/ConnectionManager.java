package access_control.ex08.connection;


import java.util.ArrayList;


public class ConnectionManager {
    private static final int NUM_OF_CONNECTIONS = 10;
    private static ArrayList<Connection> connections;
    static {
        for(int i = 0; i < NUM_OF_CONNECTIONS; ++i) {
            connections.add(new Connection());
        }
    }

    public static Connection getConnection() {
        int size = connections.size() - 1;
        return size == 0 ? null : connections.remove(size);
    }
}
