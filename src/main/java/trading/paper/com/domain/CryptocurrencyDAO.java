package trading.paper.com.domain;

import java.util.List;

public interface CryptocurrencyDAO {
	public void save(Cryptocurrency cryptocurrency);

	public Cryptocurrency findOne(int id);

	public Cryptocurrency findByTicker(String ticker);

	public List<Cryptocurrency> findAll();

	public void deleteById(int id);

	public void udpate(Cryptocurrency cryptocurrency);
}
