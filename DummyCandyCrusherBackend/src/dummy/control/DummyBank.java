package dummy.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import contract.Bank;
import dk.candycrushers.control.BankManager;
import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.BanktellerDetail;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dk.candycrushers.dto.TransactionDetail;
import dummy.model.Account;
import dummy.model.BankTeller;
import dummy.model.Customer;
import dummy.model.Person;
import dummy.model.Transaction;

public class DummyBank implements BankManager {

    private Map<Long, Customer> customers = new HashMap<>();
//    private Map<String, String> users = new HashMap<>();
    private Map<Long, BankTeller> banktellers = new HashMap<>();
    private Map<Long, Person> persons = new HashMap<>();
    private Account account;
    private AccountDetail accountDetail;
    private List<Account> accounts = new ArrayList();
    private List<AccountDetail> accountDetails = new ArrayList();
        private List<Transaction> transactions = new ArrayList();
    //    private List<Transaction> transactions = new ArrayList();

    public DummyBank() {

        Customer cust = new Customer("Donald", "Duck", "donald@duck.com", "w", 1);
        Account account1 = new Account("Basic Account", 0);
        cust.addAccount(account1);
        account1.createTransaction(20000, "Salary");
        account1.createTransaction(-8000, "Morgage payment");
        account1.createTransaction(-1000, "To savings");
        account1.createTransaction(-1500, "Car Loan");
        account1.createTransaction(-1000, "Ensurance");
        customers.put(cust.getCustomerId(), cust);
        this.account = account1;
        accounts.add(account1);

        cust = new Customer("Mickey", "Mouse", "mickey@mouse.com", "w", 1);
        Account account2 = new Account("Basic Account2", 0);
        cust.addAccount(account2);
        account2.createTransaction(7, "Salary2");
        account2.createTransaction(-5, "bill");
        account2.createTransaction(-5, "bill2");
        account2.createTransaction(-5, "bill3");
        account2.createTransaction(-5, "bill4");
        customers.put(cust.getCustomerId(), cust);
        accounts.add(account2);

        BankTeller bankt = new BankTeller("Mogens", "Hansen", "mh@bankt.com", "q", 2);
        banktellers.put(bankt.getBanktellerid(), bankt);

    }

    @Override
    public String sayHello(String name) {
        return "Hello "+name+" from Dummy Bank Manager";
    }

    
    
    @Override
    public Collection<CustomerSummary> getCustomers() {
        return DummyBankAssembler.createCustomerSummaries(customers.values());
    }

    @Override
    public CustomerDetail getCustomer(long id) {
        return DummyBankAssembler.createCustomerDetail(customers.get(id));
    }

    @Override
    public AccountDetail getAccount(long id) {

        return accountDetail;
    }

    @Override
    public CustomerDetail addCustomer(String firstname, String lastName, String email, String password, int role) {
        Customer newCust = new Customer(firstname, lastName, email, password, role);
        customers.put(newCust.getCustomerId(), newCust);
        return DummyBankAssembler.createCustomerDetail(newCust);
    }
    
    @Override
    public CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email) {
        Customer cusReturn = null;

        for (Customer cus : customers.values()) {
            if (cus.getCustomerId() == customerID) {
                cus.setFirstName(firstName);
                cus.setLastName(lastName);
                cus.setEmail(email);
                cusReturn = cus;
            }
        }

        return DummyBankAssembler.createCustomerDetail(cusReturn);
    }


    @Override
    public AccountDetail transactionToAnOtherAccount(int fromAccountId, int toAccountId, double amount) {
        String returnString = "Transaction did not complete ..";
        double minusAmount = amount - (2 * amount);

        try {
            AccountDetail fromAccount = getAccountTransactionToEachOther(fromAccountId);
            fromAccount.createTransaction(minusAmount, amount + " has been moved to account number: " + toAccountId);

            AccountDetail toAccount = getAccountTransactionToEachOther(toAccountId);
            toAccount.createTransaction(amount, amount + " has been inserted from account number: " + fromAccount.getAccountId());
            returnString = "Transaction complete!";
        } catch (Exception e) {
        }
        return DummyBankAssembler.createAccountDetail(account);
    }
    
//        public AccountDetail transactionToAnOtherAccount(int fromAccountId, int toAccountId, double amount) {
//        Account fromAcc = em.find(Account.class, fromAccountId);
//        
//        Account toAcc = em.find(Account.class, toAccountId);
//        
//        toAcc.setBalance(toAcc.getBalance() + amount);
//        
//        fromAcc.setBalance(fromAcc.getBalance() - amount);
//        double balance = 0;
//        
//        Transaction t = new Transaction(new Date(), amount, balance, "Some info", "Some message", fromAcc, toAcc);
//        em.persist(t);
//        return createAccountDetail(fromAcc);
//    }

    @Override
    public AccountDetail getAccountTransactionToEachOther(long accountId) {
        AccountDetail accountReturn = null;
        for (int i = 0; i <= accounts.size() - 1; i++) {
            if (accounts.get(i).getAccountId() == accountId) {
                accountReturn = accountDetails.get(i);
            }
        }
        return accountReturn;
//        for (Account acc : accounts) {
//            if (cus.getFirstName().equals(username)) {
//                if (cus.getPassword().equals(password)) {
//                    person = cus;
//                }
//            }
//        }
    }

    @Override
    public AccountDetail addAccount(String accountType, double balance, long customerID) {
           Account acc = new Account(accountType, balance);
        return DummyBankAssembler.createAccountDetail(acc);
    }

    @Override
    public CustomerDetail getCustomerByEmail(String email) {
             return DummyBankAssembler.createCustomerDetail(customers.get(email));
    }

    @Override
    public BanktellerDetail getBanktellerByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TransactionDetail> getTransactionDetails(int accountId) {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
