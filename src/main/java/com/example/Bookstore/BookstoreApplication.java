package com.example.Bookstore;

import com.example.Bookstore.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(TradeRepository tradeRepository, StockRepository stockRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			stockRepository.save(new Stock("Romance"));
			stockRepository.save(new Stock("Fantasy"));


			log.info("save a couple of books");
			tradeRepository.save(new Trade("9781781101032", "Harry Potter à l'école des sorciers", "J. K. Rowling", 1997, 9.90, stockRepository.findByName("Fantasy").get(0)));
			tradeRepository.save(new Trade("9782709641944", "Fifty Shades of Grey", "E. L. James", 2011, 6.49, stockRepository.findByName("Romance").get(0)));

			log.info("Save two users");
			userRepository.save(new User("patr74admin", "$2y$10$YTn3OO4lUwb3rz2vrJ2dA.RDNNMbRZlQww2Rkh9kISnA2JF5DvMZG", "patr74admin@hotmail.com", "ADMIN"));
			userRepository.save(new User("patr74user", "$2y$10$6MYqXRHobELLjJChB2mcy.WeZAC3f6Wk0w3Z8Jt3Jlckvss8c.ZlK", "patr74user@hotmail.com", "USER"));

			log.info("fetch all categories");
			for (Stock stock : stockRepository.findAll()) {
				log.info(stock.toString());
			}

			log.info("fetch all students");
			for (Trade trade : tradeRepository.findAll()) {
				log.info(trade.toString());
			}

		};
	}
}
