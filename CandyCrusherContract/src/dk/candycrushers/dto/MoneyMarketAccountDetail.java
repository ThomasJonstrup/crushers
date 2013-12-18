/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

import java.io.Serializable;

/**
 *
 * @author Thomas
 */
public class MoneyMarketAccountDetail extends AccountDetail implements Serializable {
    
    private double minBalance;

    public MoneyMarketAccountDetail(long accountId, String accountType, double balance, String owner, double minBalance) {
        super(accountId, accountType, balance, owner);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }
    
 

}
