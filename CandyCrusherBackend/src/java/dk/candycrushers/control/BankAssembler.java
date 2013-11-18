/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.control;

import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.AccountSummary;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dk.candycrushers.model.Account;
import dk.candycrushers.model.Customer;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thomas
 */
public class BankAssembler {

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
        CustomerDetail detail = new CustomerDetail(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail());

        detail.setAccounts(createAccountDetails(customer.getAccounts()));
        return detail;
    }

    public static AccountDetail createAccountDetail(Account account) {

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
}
