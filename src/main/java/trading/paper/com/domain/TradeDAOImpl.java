package trading.paper.com.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TradeDAOImpl implements TradeDAO {  // Impl = Implementation class
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Trade trade) {
		String sql = "insert into trade(trade_day, trade_month, trade_year, trade_amount, trade_entry, trade_exit, trade_crypto_id) values(?,?,?,?,?,?,?)";
		Object[] parameters = new Object[] {
				trade.getDay(),
				trade.getMonth(),
				trade.getYear(),
				trade.getAmount(),
				trade.getEntryPrice(),
				trade.getExitPrice(),
				trade.getCryptocurrency()
		};
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public Trade findOne(int id) {
		String sql = "select * from trade where trade_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Trade> mapper = new TradeRowMapper();
		return jdbcTemplate.queryForObject(sql, parameters, mapper);
	}

	@Override
	public List<Trade> findAll() {
		String sql = "select * from trade";
		RowMapper<Trade> mapper = new TradeRowMapper();
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM trade WHERE trade_id = ?";
		Object[] parameters = new Object[] { id };
		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public void udpate(Trade trade) {
		String sql = "update trade set trade_amount = ?, trade_entry = ?, trade_exit = ? where trade_id = ?";
		Object[] parameters = new Object[] {
				trade.getAmount(),
				trade.getEntryPrice(),
				trade.getExitPrice(),
				trade.getId()
		};
		jdbcTemplate.update(sql, parameters);
	}
}
