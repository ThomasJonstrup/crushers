/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ratetest;

import client.CurrencyRateClient;

/**
 *
 * @author Thomas
 */
public class RateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CurrencyRateClient rate = new CurrencyRateClient();
        String res = rate.find_JSON(String.class, "USD");
        rate.close();
        System.out.println(res);
       
    }
}
