package com.example.main;

import com.example.mappers.StudentRowMapper;
import com.example.resources.SpringConfigFile;
import com.example.tabledata.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class); //

        // ------------------------ INSERT QUERY ------------------------
        // int inserted_rows = jdbcTemplate.update("INSERT INTO student VALUES(15, 'Piyush', 80.12)");
//        int std_roll_number = 8;
//        String std_name = "Vishal";
//        Float std_marks = 76.18f;
//        String insert_query = "INSERT INTO student VALUES(?, ?, ?)";
//
//        int inserted_rows = jdbcTemplate.update(insert_query, std_roll_number, std_name, std_marks); // using update() methods you can perform insert, update and delete query's
//        if (inserted_rows > 0) {
//            System.out.println("Data Insert Successfully.");
//        } else {
//            System.out.println("Data Insert Filed.");
//        }


        // ------------------------ UPDATE QUERY ------------------------
//        int updated_rows = jdbcTemplate.update("UPDATE student SET std_marks=82.15 WHERE std_roll_number=15");
//        if (updated_rows > 0) {
//            System.out.println("Data Update Successfully.");
//        } else {
//            System.out.println("Data Update Filed.");
//        }


        // ------------------------ DELETE QUERY ------------------------
//        int delete_rows = jdbcTemplate.update("DELETE FROM student WHERE std_roll_number=15");
//        if (delete_rows > 0) {
//            System.out.println("Data Delete Successfully.");
//        } else {
//            System.out.println("Data Delete Filed.");
//        }


        // ------------------------ SELECT QUERY FOR FULL TABLE DATA------------------------
        String select_query = "SELECT * FROM student;";
        List<Student> std_list = jdbcTemplate.query(select_query, new StudentRowMapper());

        for(Student std : std_list){
            System.out.println("Roll Number: " + std.getstd_roll_number());
            System.out.println("Name: " + std.getstd_name());
            System.out.println("Marks: " + std.getstd_marks());
            System.out.println("--------------------------------------------");
        }


        // ------------------------ SELECT QUERY FOR ONE ROW DATA ONLY ------------------------
//        int rollNumber = 8;
//        String select_query = "SELECT * FROM student WHERE std_roll_number=?;";
//        Student std = jdbcTemplate.queryForObject(select_query, new StudentRowMapper(), rollNumber); // for this method not need RowMapper (StudentRowMapper.java file)
//
//        System.out.println("Roll Number: " + std.getstd_roll_number());
//        System.out.println("Name: " + std.getstd_name());
//        System.out.println("Marks: " + std.getstd_marks());
    }
}
