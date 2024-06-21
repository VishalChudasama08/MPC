package com.example.mappers;

import com.example.tabledata.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student std = new Student();

        std.setstd_roll_number(rs.getInt("std_roll_number"));
        std.setstd_name(rs.getNString("std_name"));
        std.setstd_marks(rs.getFloat("std_marks"));

        return std;
    }
}
