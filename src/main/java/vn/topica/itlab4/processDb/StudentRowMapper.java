package vn.topica.itlab4.processDb;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.topica.itlab4.model.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student st = new Student(rs.getString("id"),rs.getString("name"),rs.getDate("birthOfDate"),rs.getString("gender"));

        return st;

    }
}