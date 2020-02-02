package util;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");

    private static String Driver;
    private static String Url;
    private static String User;
    private static String Password;

    static {
        Driver = bundle.getString("DRIVER");
        Url = bundle.getString("URL");
        User = bundle.getString("USER");
        Password = bundle.getString("PASSWORD");
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(Url,User,Password);
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void release(ResultSet set, Statement statement, Connection connection){
        if (set != null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
