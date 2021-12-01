package trading.paper.com.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUsername(rs.getString("user_username"));
		user.setPasswordHash(rs.getString("user_password"));
		user.setEmail(rs.getString("user_email"));
		user.setRole(rs.getString("user_role"));
		return user;
	}

}
