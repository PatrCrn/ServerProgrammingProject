package trading.paper.com.domain;

import java.util.List;

public interface UserDAO {
	public void save(User user);

	public User findOne(int id);

	public User findByUsername(String username);

	public List<User> findAll();

	public void deleteById(int id);

	public void udpate(User user);
}
