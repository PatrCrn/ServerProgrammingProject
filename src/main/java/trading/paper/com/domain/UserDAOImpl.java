package trading.paper.com.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {  // Impl = Implementation class
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User user) {
		String sql = "insert into user(user_username, user_password, user_email, user_role) values(?,?,?,?)";
		Object[] parameters = new Object[] {
				user.getUsername(),
				user.getPasswordHash(),
				user.getEmail(),
				user.getRole()
		};
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public User findOne(int id) {
		String sql = "select * from user where user_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<User> mapper = new UserRowMapper();
		return jdbcTemplate.queryForObject(sql, parameters, mapper);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "select * from user where user_username = ?";
		Object[] parameters = new Object[] { username };
		RowMapper<User> mapper = new UserRowMapper();
		return jdbcTemplate.queryForObject(sql, parameters, mapper);
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		RowMapper<User> mapper = new UserRowMapper();
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM user WHERE user_id = ?";
		Object[] parameters = new Object[] { id };
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public void udpate(User user) {
		String sql = "update user set user_email = ? where user_id = ?";
		Object[] parameters = new Object[] {
				user.getEmail(),
				user.getId()
		};
		jdbcTemplate.update(sql, parameters);
	}
}
