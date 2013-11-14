/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

import java.util.Date;

/**
 *
 * @author Thomas
 */
public class TransactionDetail {

    private long transactionId;
    private Date timestamp;
    private double amount;
    private double balance;
    private String info;

    public TransactionDetail(long transactionId, Date timestamp, double amount, double balance, String info) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.balance = balance;
        this.info = info;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getInfo() {
        return info;
    }
    
    
}
