/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.control;

import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.AccountSummary;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dk.candycrushers.dto.TransactionDetail;
import dk.candycrushers.dto.TransactionSummary;
import dummy.model.Account;
import dummy.model.Customer;
import dummy.model.Transaction;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class DummyBankAssembler {

    public static CustomerSummary createCustomerSummary(Customer customer) {
        return new CustomerSummary(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }

    public static Collection<CustomerSummary> createCustomerSummaries(Collection<Customer> customers) {
        Collection<CustomerSummary> summaries = new ArrayList<>();
        for (Customer customer : customers) {
            summaries.add(createCustomerSummary(customer));
        }
        return summaries;
    }

    public static CustomerDetail createCustomerDetail(Customer customer) {
        return new CustomerDetail(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail());
    }

    public static AccountSummary createAccountSummary(Account account) {
        return new AccountSummary(
                account.getAccountId(),
                account.getAccountType());
    }

    public static AccountDetail createAccountDetail(Account account) {
        return new AccountDetail(
                account.getAccountId(),
                account.getAccountType(),
                account.getBalance(),
                "" + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
    }
    
        public static Collection<TransactionDetail> createAccountDetails(Collection<Transaction> transaction) {
        Collection<TransactionDetail> transactionDetails = new ArrayList<>();
        for (Transaction trans : transaction) {
            transactionDetails.add(createTransactionDetail(trans));
        }
        return transactionDetails;
        
        
    }
        
            public static TransactionSummary createTransactionSummary(Transaction transaction) {
        return new TransactionSummary(transaction.getBalance(), transaction.getInfo());

    }
            
                public static TransactionDetail createTransactionDetail(Transaction transaction) {
        return new TransactionDetail(
                transaction.getTransactionId(),
                transaction.getTimestamp(),
                transaction.getAmount(),
                transaction.getBalance(),
                transaction.getInfo());
    }

}
