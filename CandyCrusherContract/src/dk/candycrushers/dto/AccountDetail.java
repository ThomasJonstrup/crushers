/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class AccountDetail implements Serializable {

    private long accountId;
    private String accountType;
    private double balance;
    private String owner;
//    private List<Transaction> transactions = new ArrayList();

    public AccountDetail(long accountId, String accountType, double balance, String owner) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
        this.owner = owner;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

//    public List<Transaction> getTransactions() {
//        return transactions;
//    }
    
    
    
}
