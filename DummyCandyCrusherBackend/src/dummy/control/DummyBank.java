package dummy.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import contract.Bank;
import dk.candycrushers.control.BankManager;
import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dummy.model.Account;
import dummy.model.BankTeller;
import dummy.model.Customer;
import dummy.model.Person;

public class DummyBank implements BankManager {

    private Map<Long, Customer> customers = new HashMap<>();
//    private Map<String, String> users = new HashMap<>();
    private Map<Long, BankTeller> banktellers = new HashMap<>();
    private Map<Long, Person> persons = new HashMap<>();
    private Account account;
    private AccountDetail accountDetail;
    private List<Account> accounts = new ArrayList();
    private List<AccountDetail> accountDetails = new ArrayList();
    //    private List<Transaction> transactions = new ArrayList();
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
    public AccountDetail getAccount() {

        return accountDetail;
    }

    @Override
    public CustomerDetail addCustomer(String firstname, String lastName, String email, String password, int role) {
        Customer newCust = new Customer(firstname, lastName, email, password, role);
        customers.put(newCust.getCustomerId(), newCust);
        return DummyBankAssembler.createCustomerDetail(newCust);
    }
    
    @Override
    public CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email, String password) {
        Customer cusReturn = null;

        for (Customer cus : customers.values()) {
            if (cus.getCustomerId() == customerID) {
                cus.setFirstName(firstName);
                cus.setLastName(lastName);
                cus.setEmail(email);
                cus.setPassword(password);
                cusReturn = cus;
            }
        }

        return DummyBankAssembler.createCustomerDetail(cusReturn);
    }


    @Override
    public void addAccount(AccountDetail account) {
        accountDetails.add(account);
    }
//
//    @Override
//    public Person checkLogin(String username, String password) {
//        Person person = null;
//        for (Customer cus : customers.values()) {
//            if (cus.getFirstName().equals(username)) {
//                if (cus.getPassword().equals(password)) {
//                    person = cus;
//                }
//            }
//        }
//        if (person == null) {
//            for (BankTeller bankTeller : banktellers.values()) {
//                if (bankTeller.getFirstName().equals(username)) {
//                    if (bankTeller.getPassword().equals(password)) {
//                        person = bankTeller;
//                    }
//                }
//            }
//        }
//        return person;
//    }
//
//    @Override
//    public void addBankTeller(String firstname, String lastName, String email, String password, int role) {
//        BankTeller newBankT = new BankTeller(firstname, lastName, email, password, role);
//        banktellers.put(newBankT.getBanktellerid(), newBankT);
//    }
//
//    @Override
//    public BankTeller getBankTeller(long id) {
//        return banktellers.get(id);
//    }
//
//    @Override
//    public Collection<BankTeller> getBankTellers() {
//        return banktellers.values();
//    }
//
//    @Override


    @Override
    public String transactionToAnOtherAccount(int fromAccountId, int toAccountId, double amount) {
        String returnString = "Transaction did not complete ..";
        double minusAmount = amount - (2 * amount);

        try {
            Account fromAccount = getAccountTransactionToEachOther(fromAccountId);
            fromAccount.createTransaction(minusAmount, amount + " has been moved to account number: " + toAccountId);

            Account toAccount = getAccountTransactionToEachOther(toAccountId);
            toAccount.createTransaction(amount, amount + " has been inserted from account number: " + fromAccount.getAccountId());
            returnString = "Transaction complete!";
        } catch (Exception e) {
        }
        return returnString;
    }

    @Override
    public AccountDetail getAccountTransactionToEachOther(long accountId) {
        Account accountReturn = null;
        for (int i = 0; i <= accounts.size() - 1; i++) {
            if (accounts.get(i).getAccountId() == accountId) {
                accountReturn = accounts.get(i);
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




}
