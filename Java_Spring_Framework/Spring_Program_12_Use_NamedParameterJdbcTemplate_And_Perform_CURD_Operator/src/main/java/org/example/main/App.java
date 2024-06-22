package org.example.main;

import org.example.configuration.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);

//        NamedParameterJdbcTemplate npjt = (NamedParameterJdbcTemplate) context.getBean("myNameParameterJdbcTem()");
        NamedParameterJdbcTemplate npJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);

        // -------------------------- INSERT QUERY --------------------------
//        Map<String, Object> map = new HashMap<>(); // create Map<> and use .put() method to set key and value
//        map.put("keyRollNumber", 15);
//        map.put("keyName", "Darshan");
//        map.put("keyMarks", 85.15f);
//
//        String insert_query = "INSERT INTO student VALUES(:keyRollNumber, :keyName, :keyMarks);"; // :<name> it is "name parameter"
//
//        int count = npJdbcTemplate.update(insert_query, map); // update() method use ot run insert, update and update sql query, return integer
//        // update() method arguments -
//        // 1st - sql query
//        // 2nd - Map<> object
//
//        if(count > 0){
//            System.out.println("Data Insert Successfully");
//        } else {
//            System.out.println("Data Insert Field");
//        }


        // -------------------------- UPDATE QUERY --------------------------
        Map<String, Object> map = new HashMap<>();
        map.put("keyRollNumber", 28);
        map.put("keyName", "Darshan");
        String update_query = "UPDATE student set std_roll_number=:keyRollNumber WHERE std_name=:keyName ;"; // :<name> it is "name parameter"

        int count = npJdbcTemplate.update(update_query, map); // update() method use ot run insert, update and update sql query, return integer
        // update() method arguments -
        // 1st - sql query
        // 2nd - Map<> object

        if(count > 0){
            System.out.println("Data Update Successfully");
        } else {
            System.out.println("Data Update Field");
        }


        // -------------------------- DELETE QUERY --------------------------
//        Map<String, Object> map = new HashMap<>();
//        map.put("keyRollNumber", 28);
//        String delete_query = "DELETE FROM student WHERE std_roll_number=:keyRollNumber ;"; // :<name> it is "name parameter"
//
//        int count = npJdbcTemplate.update(delete_query, map); // update() method use ot run insert, update and update sql query, return integer
//        // update() method arguments -
//        // 1st - sql query
//        // 2nd - Map<> object
//
//        if(count > 0){
//            System.out.println("Data Delete Successfully");
//        } else {
//            System.out.println("Data Delete Field");
//        }
    }
}
