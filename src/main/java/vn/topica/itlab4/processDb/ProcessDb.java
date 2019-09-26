package vn.topica.itlab4.processDb;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import javax.sql.DataSource;

import vn.topica.itlab4.model.Student;

public class ProcessDb {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	 public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	      
	   }
	public void insert(Student st) {
		String sql = "INSERT INTO STUDENT (ID,NAME,BIRTHOFDATE,GENDER) VALUE (?,?,?,?)";
		jdbcTemplateObject.update(sql, st.getId(), st.getName(), st.getDateOfBirth(), st.getGender());
	}
	
	public List<Student> findAll() {
		
        String sql = "SELECT * FROM STUDENT";

        List<Student> listSt = jdbcTemplateObject.query(sql,new StudentRowMapper());
        return listSt;
		
    }
	public void remove(String id) {
		String sql="DELETE FROM STUDENT WHERE ID="+id;
		jdbcTemplateObject.update(sql);
	}
}
