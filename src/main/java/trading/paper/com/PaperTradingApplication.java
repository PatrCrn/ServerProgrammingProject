package trading.paper.com;

import trading.paper.com.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaperTradingApplication {
	private static final Logger log = LoggerFactory.getLogger(PaperTradingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PaperTradingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner tradingDemo(TradeDAOImpl tradeDAO, CryptocurrencyDAOImpl cryptocurrencyDAO, UserDAOImpl userDAO) {
		return (args) -> {
			log.info("Save two users");
			//userDAO.save(new User("patr74admin", "$2a$12$/MniID6CbVMEXqVsVwFk4.UqRQfKLYW1xzdJZ4Dt0E5g0JIYXYut.", "patr74admin@hotmail.com", "ADMIN"));
			// password for admin : pepeadmin
			//userDAO.save(new User("patr74user", "$2a$12$WazcuIZlpylplvOAEThU7eUPdGJNvzGUakntMouox8VkNxRW8m0Mm", "patr74user@hotmail.com", "USER"));
			// password for user : pepeuser

			log.info("save some cryptos");
			//cryptocurrencyDAO.save(new Cryptocurrency("Bitcoin", "BTC"));
			//cryptocurrencyDAO.save(new Cryptocurrency("Ethereum", "ETH"));
			//cryptocurrencyDAO.save(new Cryptocurrency("Solana", "SOL"));

			log.info("do some trades");
			// cryptocurrencyDAO.findByTicker("SOL")
			tradeDAO.save(new Trade(29, "november", 2021, 500, 234.5, 245.6, cryptocurrencyDAO.findByTicker("SOL").getCryptoId()));
			// cryptocurrencyDAO.findByTicker("SOL")
			tradeDAO.save(new Trade(15, "november", 2021, 250, 955, 986.4, cryptocurrencyDAO.findByTicker("ETH").getCryptoId()));
			// cryptocurrencyDAO.findByTicker("SOL")
			tradeDAO.save(new Trade(18, "november", 2021, 700, 54560, 66590, cryptocurrencyDAO.findByTicker("BTC").getCryptoId()));

			log.info("fetch all cryptos");
			for (Cryptocurrency cryptocurrency : cryptocurrencyDAO.findAll()) {
				log.info(cryptocurrency.toString());
			}

			log.info("fetch all trades");
			for (Trade trade : tradeDAO.findAll()) {
				log.info(trade.toString());
			}

			log.info("fetch all users");
			for (User user : userDAO.findAll()) {
				log.info(user.toString());
			}
		};
	}
}
