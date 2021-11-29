package com.example.Bookstore.web;

import com.example.Bookstore.domain.Trade;
import com.example.Bookstore.domain.TradeRepository;
import com.example.Bookstore.domain.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class TradingController {
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private StockRepository stockRepository;

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    // Get all trades
    @RequestMapping(value= {"/", "/alltrades"})
    public String allTrades(Model model) {
        model.addAttribute("trades", tradeRepository.findAll());
        return "alltrades";
    }

    // RESTful service to get all trades in JSON format
    @RequestMapping(value="/trades", method = RequestMethod.GET)
    public @ResponseBody List<Trade> allTradesRest() {
        return (List<Trade>) tradeRepository.findAll();
    }

    // RESTful service to get a trade by ID in JSON format
    @RequestMapping(value="/trade/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Trade> findTradeRest(@PathVariable("id") String bookIsbn) {
        return tradeRepository.findById(bookIsbn);
    }

    // add a new trade
    @RequestMapping(value = "/add")
    public String addTrade(Model model){
        model.addAttribute("trade", new Trade());
        model.addAttribute("stocks", stockRepository.findAll());
        return "addtrade";
    }

    // Save the trade
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Trade trade){
        tradeRepository.save(trade);
        return "redirect:alltrades";
    }

    // Delete a trade
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteTrade(@PathVariable("id") String tradeId, Model model) {
        tradeRepository.deleteById(tradeId);
        return "redirect:../alltrades";
    }

    // Edit a trade
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateTrade(@PathVariable("id") String tradeId, Model model) {
        Optional<Trade> trade = tradeRepository.findById(tradeId);

        model.addAttribute("trade", trade);
        model.addAttribute("stocks", stockRepository.findAll());

        return "updatetrade";
    }
}
