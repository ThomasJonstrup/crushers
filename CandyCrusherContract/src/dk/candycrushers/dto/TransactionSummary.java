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
public class TransactionSummary implements Serializable {
    
    
    private double balance;
    private String message;

    public TransactionSummary(double balance, String message) {
        this.balance = balance;
        this.message = message;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
