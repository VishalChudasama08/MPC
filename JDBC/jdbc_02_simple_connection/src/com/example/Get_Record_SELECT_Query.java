package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Get_Record_SELECT_Query {
    public static void main(String[] args) throws Exception {
        // add mysql-connector-j-8.4.0.jar file (same version as mysql version)
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", ""); // use xampp mysql


        PreparedStatement ps = conn.prepareStatement("SELECT * FROM register;");

        ResultSet rs = ps.executeQuery(); // return in ResultSet
        int i = 1;
        while(rs.next()){ // .next() get next row record
            System.out.println("\nRow " + i + " Record:-");
            String name = rs.getString("name");
            System.out.println("\tName: " + name);

            String email = rs.getString("email");
            System.out.println("\temail: " + email);

            String password = rs.getString("password");
            System.out.println("\tPassword: " + password);

            String gender = rs.getString("gender");
            System.out.println("\tGender: " + gender);

            String city = rs.getString("city");
            System.out.println("\tCity: " + city);
            i++;
        }
    }

}
