/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.control;

import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.BanktellerDetail;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dk.candycrushers.dto.TransactionDetail;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Thomas
 */
@Remote // Remote Bean  anotation
public interface BankManager {

    String sayHello(String name);
    Collection<CustomerSummary> getCustomers();
    CustomerDetail getCustomer(long id);
    CustomerDetail getCustomerByEmail(String email);
    CustomerDetail addCustomer(String firstName, String lastName, String email, String password, int role);
    CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email);

    //Trial exam:
    int getCustomerCount();
    
    int getBanktellerCount();
    
    AccountDetail addAccount(String accountType, double balance, long customerID);
    AccountDetail getAccount(long id);
    AccountDetail transactionToAnOtherAccount(int fromAccountId, int toAccountId, double amount);
    AccountDetail getAccountTransactionToEachOther(long accountId);
    
    Collection<TransactionDetail> getTransactionDetails(int accountId);
    
    BanktellerDetail getBanktellerByEmail(String email);
    
    

}
