package trading.paper.com.domain;

import java.util.List;

public interface TradeDAO {
	public void save(Trade trade);

	public Trade findOne(int id);

	public List<Trade> findAll();

	public void deleteById(int id);

	public void udpate(Trade trade);
}
