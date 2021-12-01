package trading.paper.com.domain;

import java.util.Date;
import java.util.List;

public class Cryptocurrency {
    private int cryptoId;
    private String name;
    private String ticker;
    private Date dateAdded;
    private List<Trade> trades;

    public Cryptocurrency() {
        this.cryptoId = 0;
        this.name = null;
        this.ticker = null;
        this.dateAdded = null;
    }

    public Cryptocurrency(String name, String ticker) {
        this.name = name;
        this.ticker = ticker;
        this.dateAdded = new Date();
    }

    public int getCryptoId() {
        return cryptoId;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setCryptoId(int cryptoId) {
        this.cryptoId = cryptoId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public String toString() {
        return ticker;
    }
}
