package org.example.potoki4;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection connection;
    public Database() {
        try {
            String databaseUser = "ADMIN";
            String databasePassword = "";
            String databaseName = "ethernet";
            String url = "jdbc:mariadb://localhost:3306/" + databaseName;
            connection = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
