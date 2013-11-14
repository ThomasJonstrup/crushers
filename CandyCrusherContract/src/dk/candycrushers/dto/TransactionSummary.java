/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.dto;

/**
 *
 * @author Thomas
 */
public class TransactionSummary {
    
    
    private double ammount;
    private String message;

    public TransactionSummary(double ammount, String message) {
        this.ammount = ammount;
        this.message = message;
    }

    public double getAmmount() {
        return ammount;
    }

    public String getMessage() {
        return message;
    }

    
    
}
