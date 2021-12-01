package trading.paper.com.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CryptocurrencyRowMapper implements RowMapper<Cryptocurrency> {

	public Cryptocurrency mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cryptocurrency cryptocurrency = new Cryptocurrency();
		cryptocurrency.setCryptoId(rs.getInt("crypto_id"));
		cryptocurrency.setName(rs.getString("crypto_name"));
		cryptocurrency.setTicker(rs.getString("crypto_ticker"));
		cryptocurrency.setDateAdded(rs.getDate("crypto_date"));
		return cryptocurrency;
	}

}
