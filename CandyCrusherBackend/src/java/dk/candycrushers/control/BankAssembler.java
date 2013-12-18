/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.control;

import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.AccountSummary;
import dk.candycrushers.dto.BanktellerDetail;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dk.candycrushers.dto.MoneyMarketAccountDetail;
import dk.candycrushers.dto.TimeDepositAccountDetail;
import dk.candycrushers.dto.TransactionDetail;
import dk.candycrushers.dto.TransactionSummary;
import dk.candycrushers.model.Account;
import dk.candycrushers.model.Bankteller;
import dk.candycrushers.model.Customer;
import dk.candycrushers.model.MoneyMarketAccount;
import dk.candycrushers.model.TimeDepositAccount;
import dk.candycrushers.model.Transaction;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class BankAssembler {

    public static CustomerSummary createCustomerSummary(Customer customer) {
        return new CustomerSummary(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPerson().getEmail());
    }

    public static Collection<CustomerSummary> createCustomerSummaries(Collection<Customer> customers) {
        Collection<CustomerSummary> summaries = new ArrayList<>();
        for (Customer customer : customers) {
            summaries.add(createCustomerSummary(customer));
        }
        return summaries;
    }

    public static CustomerDetail createCustomerDetail(Customer customer) {
        if (customer == null) return null;
        CustomerDetail detail = new CustomerDetail(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPerson().getEmail());

        detail.setAccounts(createAccountDetails(customer.getAccounts()));
        return detail;
        
    }

    public static AccountDetail createAccountDetail(Account account) {
        if (account instanceof MoneyMarketAccount) {
          MoneyMarketAccount mm = (MoneyMarketAccount)account;
          return new MoneyMarketAccountDetail( 
                  (long)mm.getAccountId(), 
                  mm.getAccountType(), 
                  mm.getBalance(), 
                  "" + mm.getOwner().getFirstName()+""+ mm.getOwner().getLastName(),
                  mm.getMinBalance()
                  );
        }
//        if (account instanceof TimeDepositAccount) {
//            TimeDepositAccount time = (TimeDepositAccount)account;
//            return new TimeDepositAccountDetail(
//                    time.getAccountId(), 
//                    time.getAccountType(), 
//                    time.getBalance(),
//                    "" + time.getOwner().getFirstName()+"" + time.getOwner().getLastName(),
//                    time.getStartDate(), 
//                    time.getEndDate());
//        }
        
        return new AccountDetail(
                account.getAccountId(),
                account.getAccountType(),
                account.getBalance(),
                "" + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
    }

    public static Collection<AccountDetail> createAccountDetails(Collection<Account> accounts) {
        Collection<AccountDetail> details = new ArrayList<>();
        for (Account account : accounts) {
            details.add(createAccountDetail(account));
        }
        return details;
    }

    public static AccountSummary createAccountSummary(Account account) {
        return new AccountSummary(account.getAccountId(), account.getAccountType());
    }

    public static Collection<AccountSummary> createAccountSummaries(Collection<Account> accounts) {
        Collection<AccountSummary> summaries = new ArrayList<>();
        for (Account account : accounts) {
            summaries.add(createAccountSummary(account));
        }
        return summaries;
    }

    public static TransactionSummary createTransactionSummary(Transaction transaction) {
        return new TransactionSummary(transaction.getBalance(), transaction.getMessage());

    }

    public static TransactionDetail createTransactionDetail(Transaction transaction) {
        return new TransactionDetail(
                transaction.getTransactionId(),
                transaction.getTransactionDate(),
                transaction.getAmmount(),
                transaction.getBalance(),
                transaction.getInfo());
    }

    public static BanktellerDetail createBantktellerDetail(Bankteller bankteller) {
        BanktellerDetail detail = new BanktellerDetail(
                bankteller.getBanktellerId(),
                bankteller.getFirstName(),
                bankteller.getLastName(),
                bankteller.getPerson().getEmail());

//        detail.setAccounts(createAccountDetails(customer.getAccounts()));
        return detail;
    }
    
    public static Collection<TransactionDetail> createTransactionDetails(Collection<Transaction> transaction) {
        Collection<TransactionDetail> transactionDetails = new ArrayList<>();
        for (Transaction trans : transaction) {
            transactionDetails.add(createTransactionDetail(trans));
        }
        return transactionDetails;
    }
}
