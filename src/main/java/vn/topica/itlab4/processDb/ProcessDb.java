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
		System.out.println(st.getId());
	}
//	public void select() {
//		String sql="SELECT * FROM STUDENT";
//		List<Student> customers = jdbcTemplateObject.query(sql,new BeanPropertyRowMapper(Student.class));
//		for(Student s: customers) {
//			System.out.println(s.toString());
//		}
//	}
}
