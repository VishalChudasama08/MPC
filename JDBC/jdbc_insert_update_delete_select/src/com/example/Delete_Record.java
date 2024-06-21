package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete_Record {
    public static void main(String[] args) throws Exception {
        // add mysql-connector-j-8.4.0.jar file (same version as mysql version)
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", ""); // use xampp mysql

        PreparedStatement ps = conn.prepareStatement("DELETE FROM register WHERE email=?;");
        String email = "sagar@gmail.com";
        ps.setString(1, email);

        int v = ps.executeUpdate(); // return in integer, if query is not run successfully than return 0
        conn.close(); // close database connection
        if (v > 0) {
            System.out.println("Data Delete Successfully...");
        } else {
            System.out.println("Failed To Data Delete");
            System.out.println(ps);
        }
    }
}
