package spring.servlet.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    public static Connection getConnection(){ // I create this method for get dbConnection, this method return Connection, make static because access this class method in another class
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "");
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return conn;
    }
}
