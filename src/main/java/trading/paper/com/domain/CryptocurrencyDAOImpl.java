package trading.paper.com.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CryptocurrencyDAOImpl implements CryptocurrencyDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Cryptocurrency cryptocurrency) {
		String sql = "insert into cryptocurrency(crypto_name, crypto_ticker, crypto_date) values(?,?,?)";
		Object[] parameters = new Object[] {
				cryptocurrency.getName(),
				cryptocurrency.getTicker(),
				cryptocurrency.getDateAdded()
		};
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public Cryptocurrency findOne(int id) {
		String sql = "select * from cryptocurrency where crypto_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Cryptocurrency> mapper = new CryptocurrencyRowMapper();
		return jdbcTemplate.queryForObject(sql, parameters, mapper);
	}

	@Override
	public Cryptocurrency findByTicker(String ticker) {
		String sql = "select * from cryptocurrency where crypto_ticker = ?";
		Object[] parameters = new Object[] { ticker };
		RowMapper<Cryptocurrency> mapper = new CryptocurrencyRowMapper();
		return jdbcTemplate.queryForObject(sql, parameters, mapper);
	}

	@Override
	public List<Cryptocurrency> findAll() {
		String sql = "select * from cryptocurrency";
		RowMapper<Cryptocurrency> mapper = new CryptocurrencyRowMapper();
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM cryptocurrency WHERE crypto_id = ?";
		Object[] parameters = new Object[] { id };
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public void udpate(Cryptocurrency cryptocurrency) {
		String sql = "update cryptocurrency set crypto_name = ?, crypto_ticker = ? where crypto_id = ?";
		Object[] parameters = new Object[] {
				cryptocurrency.getName(),
				cryptocurrency.getTicker(),
				cryptocurrency.getCryptoId()
		};
		jdbcTemplate.update(sql, parameters);
	}
}
