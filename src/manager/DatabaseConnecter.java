package manager;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnecter {

    static String URL = "jdbc:mysql://localhost:3306/stdcourse_management";
    static String username = "root";
    static String pass = "BomScoob112004@";
    public static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL,username, pass);
            return connection;
        } catch (SQLException | ClassNotFoundException e){
            e.getStackTrace();
        }
        return null;
    }

    public static void disconnect(Connection connection) {
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e){
            e.getStackTrace();
        }
    }
}
