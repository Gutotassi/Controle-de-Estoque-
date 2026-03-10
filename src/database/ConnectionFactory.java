package src.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection == null){
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");
                connection = DriverManager.getConnection(url, user, password);
            }
            catch (SQLException e){
                throw new DatabaseException(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try{
                connection.close();
            }
            catch (SQLException e){
                throw new DatabaseException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fileInputStream = new FileInputStream("database.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
        catch (IOException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
