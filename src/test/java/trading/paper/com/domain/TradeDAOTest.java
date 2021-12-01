package trading.paper.com.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeDAOTest {
    @Autowired
    private TradeDAOImpl tradeDAO;

    @Autowired
    private CryptocurrencyDAO cryptocurrencyDAO;

    @Test
    public void makeNewTrade() {
        Trade trade = new Trade(26, "october", 2020, 111, 222.2, 333.3, cryptocurrencyDAO.findByTicker("SOL").getCryptoId());
        tradeDAO.save(trade);
        assertThat(trade.getId()).isNotNull();
    }

    @Test
    public void deleteTrade() {
        Trade trade = new Trade(26, "october", 2020, 111, 222.2, 333.3, cryptocurrencyDAO.findByTicker("SOL").getCryptoId());
        tradeDAO.save(trade);
        assertThat(trade.getId()).isNotNull();
        tradeDAO.deleteById(trade.getId());
        Assertions.assertNull(tradeDAO.findOne(trade.getId()));
    }
}
