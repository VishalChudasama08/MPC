package in.v8.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.v8.main.entity.User;
import in.v8.main.mapper.UsersRowMapper;

@Repository
public class UserCrudOperationsDOA {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertUser(User user) {
		boolean status = false;
		try {
			String insertQuery = "INSERT INTO users(name, email, gender, city) values(?,?,?,?)";
			int count = jdbcTemplate.update(insertQuery, user.getName(), user.getEmail(), user.getGender(), user.getCity());
			status = count > 0;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;	
	}
	
	public boolean updateUser(User user) {
		boolean status = false;
		try {
			String updateQuery = "UPDATE users SET name=?, gender=?, city=? WHERE email=?";
			int count = jdbcTemplate.update(updateQuery, user.getName(), user.getGender(), user.getCity(), user.getEmail());
			status = count > 0;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;	
	}
	
	public boolean deleteUserByEmail(String email) {
		boolean status = false;
		try {
			String deleteQuery = "DELETE FROM users WHERE email=?";
			int count = jdbcTemplate.update(deleteQuery, email);
			status = count > 0;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;	
	}
	
	public User getUserByEmail(String email) {
		try {
			String selectQuery = "SELECT * FROM users WHERE email=?";
			return jdbcTemplate.queryForObject(selectQuery, new UsersRowMapper(), email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getAllUsers(){
		try {
			String selectQuery = "SELECT * FROM users";
			return jdbcTemplate.query(selectQuery, new UsersRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
