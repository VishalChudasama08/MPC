package in.v8.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.v8.main.entity.User;

public class UsersRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setGender(rs.getString("gender"));
		user.setCity(rs.getString("city"));
		
		return user;
	}
}