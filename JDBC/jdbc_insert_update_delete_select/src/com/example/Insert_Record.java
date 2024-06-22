package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert_Record {
    public static void main(String[] args) throws Exception {
        // ****
        // first if not than start mysql server (Search 'Services' in windows search box, open it, find 'MySQL84' and click, click 'start the service' <== server is started)
        // open 'MySQL 8.4 command Line Client'  -- password is 'vishal08'
        // or xampp mysql server with username -> 'root' and password -> '' (nothing)
        // second create database 'jdbc_db'
        // third create table 'register' and use it
        // *** see jdbc_db.txt file ***
        // ****

        Class.forName("com.mysql.cj.jdbc.Driver"); // Load & Register Driver
        // in my computer install MySql shell version is 8.4.0
        // add mysql-connector-j-8.4.0.jar file (same version as mysql version)

        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "vishal08"); // Create Connection in MySql shell 8.4.0
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", ""); // Create Connection in xampp mysql
        // 1st parameter is url -> use online sql server than use that url , use localhost than use this -> "jdbc:mysql://localhost:3306/jdbc_db" url
        // 2nd username -> in my computer localhost username  is "root"
        // 3rd password -> in my computer localhost password is "vishal08"

        // .getConnection() method Connection Class ma value return kare chhe, tethi "Connection conn =" karelut chhe


        // make sql query

        // PreparedStatement ps = conn.prepareStatement("INSERT INTO register VALUES('Vishal', 'vishalchudasama143@gmail.com', 'Hey There...!', 'Male', 'Rajkot');"); // return in PreparedStatement Class

        // using variable
        String v1 = "Sagar";
        String v2 = "sagar@gmail.com";
        String v3 = "sagarAambaliya";
        String v4 = "Male";
        String v5 = "forget";
        // PreparedStatement ps =  conn.prepareStatement("INSERT INTO register VALUES('"+v1+"', '"+v2+"', '"+v3+"', '"+v4+"', '"+v5+"');"); // return in PreparedStatement Class

        PreparedStatement ps = conn.prepareStatement("INSERT INTO register VALUES(?, ?, ?, ?, ?);"); // ? it is position parameter, set values using setString(<index>, <value>) method, see in next lines
        ps.setString(1, v1); // 1 is index...
        ps.setString(2, v2);
        ps.setString(3, v3);
        ps.setString(4, v4);
        ps.setString(5, v5);


        // run sql Query
        int i = ps.executeUpdate(); // return in integer, if query is not run successfully than return 0

        conn.close(); // close database connection
        if (i > 0) {
            System.out.println("Data Insert Successfully...");
        } else {
            System.out.println("Failed To Data Insert");
        }
    }
}