package trading.paper.com.web;

import org.springframework.web.bind.annotation.ResponseBody;
import trading.paper.com.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class TradingController {
	@Autowired
	private TradeDAO tradeDAO;
    @Autowired
    private CryptocurrencyDAO cryptocurrencyDAO;

    /**
     * This section contains the login link
     **/

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    /**
     * This section contains every trade related links
     **/

	// The list of all the trades
    @RequestMapping(value= {"/", "/alltrades"})
    public String tradesList(Model model) {
        model.addAttribute("trades", tradeDAO.findAll());
        return "trades";
    }

    // The page to make a new trade
    @RequestMapping(value = "/add")
    public String addTrade(Model model){
    	model.addAttribute("trade", new Trade());
        model.addAttribute("cryptos", cryptocurrencyDAO.findAll());
        return "newtrade";
    }     

    // The path to save a trade, doesn't actually has a page
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTrade(Trade trade){
        tradeDAO.save(trade);
        return "redirect:alltrades";
    }

    // The page to update/edit a trade, not all value can be changed
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTrade(@PathVariable("id") int tradeId, Model model) {
        Trade trade = tradeDAO.findOne(tradeId);
        model.addAttribute("trade", trade);
        return "updatetrade";
    }

    // The path to update the edited trade, doesn't actually has a page
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTrade(Trade trade){
        tradeDAO.udpate(trade);
        return "redirect:alltrades";
    }

    // The path to delete a trade, doesn't shows a page
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrade(@PathVariable("id") int tradeId, Model model) {
    	tradeDAO.deleteById(tradeId);
        return "redirect:../alltrades";
    }

    /**
     * This section contains every crypto related links
     **/

    // The list of all the cryptos
    @RequestMapping(value="/allcryptos")
    public String cryptosList(Model model) {
        model.addAttribute("cryptos", cryptocurrencyDAO.findAll());
        return "cryptos";
    }

    // The page to make a new trade
    @RequestMapping(value = "/addcrypto")
    public String addCrypto(Model model){
        model.addAttribute("crypto", new Cryptocurrency());
        return "cryptoadd";
    }

    // The path to save a crypto, doesn't actually has a page
    @RequestMapping(value = "/savecrypto", method = RequestMethod.POST)
    public String saveCrypto(Cryptocurrency cryptocurrency){
        boolean exists = false;
        try {
            Cryptocurrency crypto = cryptocurrencyDAO.findByTicker(cryptocurrency.getTicker());
            if (crypto != null) {
                exists = true;
            }
        } catch (Exception ignored) {
        } finally {
            if (!exists) cryptocurrencyDAO.save(cryptocurrency);
        }
        return "redirect:allcryptos";
    }

    // The page to update/edit a crypto, not all values can be changed
    @RequestMapping(value = "/editcrypto/{id}", method = RequestMethod.GET)
    public String editCrypto(@PathVariable("id") int cryptoId, Model model) {
        Cryptocurrency cryptocurrency = cryptocurrencyDAO.findOne(cryptoId);
        model.addAttribute("crypto", cryptocurrency);
        return "cryptoedit";
    }

    // The path to update the edited a crypto, doesn't actually has a page
    @RequestMapping(value = "/updatecrypto", method = RequestMethod.POST)
    public String updateCrypto(Cryptocurrency cryptocurrency){
        cryptocurrencyDAO.udpate(cryptocurrency);
        return "redirect:allcryptos";
    }

    /**
     * This section can be used for REST services.
     **/


    // Get every trade in JSON
    @RequestMapping(value="/trades", method = RequestMethod.GET)
    public @ResponseBody List<Trade> allTradesRest() {
        return tradeDAO.findAll();
    }

    // Get a trade by ID in JSON
    @RequestMapping(value="/trades/{id}", method = RequestMethod.GET)
    public @ResponseBody Trade findTradeRest(@PathVariable("id") int tradeId) {
        return tradeDAO.findOne(tradeId);
    }

    // Get every trade in JSON
    @RequestMapping(value="/cryptos", method = RequestMethod.GET)
    public @ResponseBody List<Cryptocurrency> allTradesCryptos() {
        return cryptocurrencyDAO.findAll();
    }

    // Get a cryptocurrency by ticker in JSON
    @RequestMapping(value="/cryptos/{ticker}", method = RequestMethod.GET)
    public @ResponseBody Cryptocurrency findCryptoRest(@PathVariable("ticker") String ticker) {
        return cryptocurrencyDAO.findByTicker(ticker);
    }
}
