package access_control.ex08;


import access_control.ex08.connection.ConnectionManager;


public class Main {
    public static void main(String[] args) {
        // new Connection(); unavailable
        ConnectionManager.getConnection();
    }
}