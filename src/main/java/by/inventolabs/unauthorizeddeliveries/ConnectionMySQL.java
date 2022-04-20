package by.inventolabs.unauthorizeddeliveries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionMySQL {
    private Connection connection;
    private static final String DB_FILE_NAME = "db";
    private static final String DB_DRIVER_NAME = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";


    public ConnectionMySQL() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_FILE_NAME);
        String dbUrl = resourceBundle.getString(DB_URL);
        String dbUsername = resourceBundle.getString(DB_USERNAME);
        String dbPassword = resourceBundle.getString(DB_PASSWORD);
        String dbDriverName = resourceBundle.getString(DB_DRIVER_NAME);
        try {
            Class.forName(dbDriverName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
