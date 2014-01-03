/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package halloooo;

import com.google.gson.Gson;
import entity.Bankteller;
import entity.Person;
import java.util.Scanner;

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

//        NewJerseyClient bantellerclient = new NewJerseyClient();
//        String response = bantellerclient.find_JSON(String.class, "1");
//        System.out.println("Bankteller number 1: " + response);
//        
//        
//        Bankteller teller = new Gson().fromJson(response, Bankteller.class);
//        
//        
//        teller.setBanktellerId(25);
//        String tellerJson = new Gson().toJson(teller);
//        System.out.println(tellerJson);
//        
//        //String newOne = "{\"banktellerId\":800,\"firstName\":\"Hansine\",\"lastName\":\"Hansen\",\"email\":{\"email\":\"xxx@cph.dk\",\"password\":\"q\"}}";
//        
//        bantellerclient.create_JSON(tellerJson);

        
        
        BankTellerClient client = new BankTellerClient();
                System.out.println("Enter Bankteller id:");        
        Scanner scan = new Scanner(System.in);      
        String find_JSON = client.find_JSON(String.class, scan.nextLine());
//        System.out.println(find_JSON);
        Bankteller fromJson = new Gson().fromJson(find_JSON, Bankteller.class);
        System.out.println("Firstname: " + fromJson.getFirstName() + "\n" + "Lastname: " + fromJson.getLastName());
        
//        System.out.println("Enter new Bankteller id: ");
        
        fromJson.setBanktellerId(25);
        
//        //Person skal tilføjes først i databasen før bankteller kan tilføjes
////        Person person = new Person("hej@hej.dk", "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");
////        PersonClient pclient = new PersonClient();
////        pclient.create_JSON(new Gson().toJson(person));
////        fromJson.setEmail(person);
////        
////        //Bankteller tilføjes
////        client.create_JSON(new Gson().toJson(fromJson));



    }
}
