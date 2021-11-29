package com.example.Bookstore;

import com.example.Bookstore.domain.Trade;
import com.example.Bookstore.domain.TradeRepository;
import com.example.Bookstore.domain.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TradeRepositoryTest {

    @Autowired
    private TradeRepository repository;
    @Autowired
    private StockRepository stockRepository;

    @Test
    public void findByAuthorBook() {
        List<Trade> students = repository.findByAuthor("J. K. Rowling");
        assertThat(students).hasSize(1);
        assertThat(students.get(0).getTitle()).isEqualTo("Harry Potter à l'école des sorciers");
    }
    
    @Test
    public void createNewBook() {
        Trade trade = new Trade("9451212154541", "Joe Mama", "James Camry", 1999, 10.21, stockRepository.findByName("Romance").get(0));
    	repository.save(trade);
    	assertThat(trade.getIsbn()).isNotNull();
    }

    @Test
    public void deleteOldBook() {
        Trade trade = new Trade("9451212154541", "Joe Mama", "James Camry", 1999, 10.21, stockRepository.findByName("Romance").get(0));
        repository.save(trade);
        assertThat(trade.getIsbn()).isNotNull();
    }

}