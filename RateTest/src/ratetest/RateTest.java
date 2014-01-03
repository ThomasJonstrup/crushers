/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ratetest;

import client.CurrencyRateClient;
import com.google.gson.Gson;
import model.Rate;

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
//        String res = rate.find_JSON(String.class, "USD");
        String res = rate.findAll_JSON(String.class);
//        Rate fromJson = new Gson().fromJson(res, Rate.class);
//        System.out.println(fromJson.getCode());
        rate.close();
        System.out.println(res);
       
    }
}
