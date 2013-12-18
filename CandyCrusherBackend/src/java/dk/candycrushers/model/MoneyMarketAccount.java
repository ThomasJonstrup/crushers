package dk.candycrushers.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MONEY_MARKET_ACCOUNTS")
public class MoneyMarketAccount extends Account implements Serializable{
    
    @Column(name = "MIN_BALANCE")
    private Double minBalance;

    public MoneyMarketAccount() {
    }

    
    public MoneyMarketAccount(Double minBalance) {
        super("Money Market Account");
        this.minBalance = minBalance;
    }

    
    
    public Double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Double minBalance) {
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "Money Market Account "+getAccountId();
    }
    
    
    
}
