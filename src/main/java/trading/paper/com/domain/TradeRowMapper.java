package trading.paper.com.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TradeRowMapper implements RowMapper<Trade> {

	public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trade trade = new Trade();
		trade.setId(rs.getInt("trade_id"));
		trade.setDay(rs.getInt("trade_day"));
		trade.setMonth(rs.getString("trade_month"));
		trade.setYear(rs.getInt("trade_year"));
		trade.setAmount(rs.getInt("trade_amount"));
		trade.setEntryPrice(rs.getDouble("trade_entry"));
		trade.setExitPrice(rs.getDouble("trade_exit"));
		trade.setCryptocurrency(rs.getInt("trade_crypto_id"));
		return trade;
	}

}
