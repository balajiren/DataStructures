package MultiThreading;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Transaction {
        public static void main(String[] args) {

            Connection connection = null;
            try {

                // Load the Oracle JDBC driver

                String driverName = "oracle.jdbc.driver.OracleDriver";

                Class.forName(driverName);

                // Create a connection to the database

                String serverName = "localhost";

                String serverPort = "1521";

                String sid = "mySchema";

                String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;

                String username = "username";

                String password = "password";

                connection = DriverManager.getConnection(url, username, password);

                System.out.println("Successfully Connected to the database!");

            } catch (ClassNotFoundException e) {

                System.out.println("Could not find the database driver " + e.getMessage());
            } catch (SQLException e) {

                System.out.println("Could not connect to the database " + e.getMessage());
            }

            try {

                // Disable auto commit

                connection.setAutoCommit(false);

                // Do SQL updates...

                // Commit updates

                connection.commit();

                System.out.println("Successfully commited changes to the database!");

            } catch (SQLException e) {

                try {
                    connection.rollback();

                    System.out.println("Successfully rolled back changes from the database!");

                } catch (SQLException e1) {

                    System.out.println("Could not rollback updates " + e1.getMessage());

                }
            }

        }
}
