/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package halloooo;

/**
 *
 * @author Thomas
 */
public class Halloooo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Halllloooooo!");
        CandyCustomerClient cli = new CandyCustomerClient();
        String res = cli.find_JSON(String.class, "1");
        System.out.println("Customer number 1: " + res);
        
        
        
        CandyBanktellerClient bantellerclient = new CandyBanktellerClient();
        String response = bantellerclient.find_JSON(String.class, "1");
        System.out.println("Bankteller number 1: " + response);
        
    }
}
