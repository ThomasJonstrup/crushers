/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thomas
 */
public class Rate {
    
    private String currencyCode;
    private String currencyDesc;
    private double currencyRate;

    public Rate(String code, String desc, double rate) {
        this.currencyCode = code;
        this.currencyDesc = desc;
        this.currencyRate = rate;
    }

    public String getCode() {
        return currencyCode;
    }

    public String getDesc() {
        return currencyDesc;
    }

    public double getRate() {
        return currencyRate;
    }
    
    
}
