/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.candycrushers.control;

import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import dk.candycrushers.model.Customer;
import static dk.candycrushers.control.BankAssembler.*;
import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.BanktellerDetail;
import dk.candycrushers.dto.TransactionDetail;
import dk.candycrushers.model.Account;
import dk.candycrushers.model.Bankteller;
import dk.candycrushers.model.Person;
import dk.candycrushers.model.Role;
import dk.candycrushers.model.Transaction;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thomas
 */
@Stateless
public class BankManagerBean implements BankManager {

    @PersistenceContext(unitName = "CandyCrusherBackendPU")
    private EntityManager em;

    @Override
    public String sayHello(String name) {
        return "Hello " + name + " from Remote Bank Manager Bean";
    }

    @Override
    public Collection<CustomerSummary> getCustomers() {
        Collection<Customer> customers = em.createNamedQuery("Customer.findAll").getResultList();
        System.err.println("#CUST = " + customers.size());
        return createCustomerSummaries(customers);
    }

    @Override
    public CustomerDetail getCustomer(long id) {
//        Query q = em.createNamedQuery("Customer.findByCustomerId");
//
//        q.setParameter("id", id);
//
//        Customer cus = (Customer) q.getSingleResult();
//
        Customer cus = em.find(Customer.class, (int)id);
        CustomerDetail cDetail = new CustomerDetail(
                cus.getCustomerId(), 
                cus.getFirstName(),
                cus.getLastName(),
                cus.getPerson().getEmail()
                );

        return createCustomerDetail(cus);

    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public CustomerDetail addCustomer(String firstName, String lastName, String email, String password, int dontuse) {
        Customer customer = new Customer(firstName, lastName);
        Person person = new Person(email, password);
        Role role = em.find(Role.class, "Customers");
        person.setRoles(Collections.singleton(role));
        em.persist(person);
        customer.setPerson(person);
        em.persist(customer);
        return createCustomerDetail(customer);
    }
 
    @Override
    public AccountDetail addAccount(String accountType, double balance, long customerID) {
        Account acc = new Account(accountType);
        acc.setBalance(balance);
        
        Customer cus = em.find(Customer.class, (int)customerID);
        
        acc.setOwner(cus);
        em.persist(acc);
        
        em.refresh(cus);
        
        return createAccountDetail(acc);
    }

    @Override
    public CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email) {
//        if (id == 0) {
//            cust = new Customer(0, firstName, lastName, email, "password");
//            em.persist(cust);
//        } else {
         Customer cust = em.find(Customer.class, (int)customerID);
            cust.setFirstName(firstName);
            cust.setLastName(lastName);
            //cust.setEmail(email);
//            cust.getPerson().setEmail(email);
//            cust.setPassword(password);
////        }
        return createCustomerDetail(cust);
    }

    @Override
    public AccountDetail getAccount(long id) {
        Account acc = em.find(Account.class, (int)id);
        AccountDetail aDetail = new AccountDetail(acc.getAccountId(), acc.getAccountType(), acc.getBalance(), acc.getOwner().getFirstName());

        return createAccountDetail(acc);

    }

    @Override
    public AccountDetail transactionToAnOtherAccount(int fromAccountId, int toAccountId, double amount) {
        Account fromAcc = em.find(Account.class, fromAccountId);
        
        Account toAcc = em.find(Account.class, toAccountId);
        
        toAcc.setBalance(toAcc.getBalance() + amount);
        
        fromAcc.setBalance(fromAcc.getBalance() - amount);
        double balance = 0;
        
        Transaction t = new Transaction(new Date(), amount, balance, "Some info", "Some message", fromAcc, toAcc);
        em.persist(t);
        return createAccountDetail(fromAcc);
    }

    @Override
    public AccountDetail getAccountTransactionToEachOther(long accountId) {
//        DENNE METODE BRUGES IKKE I DET ORIGINALE PROJEKT
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDetail getCustomerByEmail(String email) {
      List<Customer> customers = 
              em.createNamedQuery("Customer.findByEmail", Customer.class)
              .setParameter("email", email)
              .getResultList();
      if (customers.isEmpty()) return null;
              //.getSingleResult();
      return createCustomerDetail(customers.get(0));
    }
    

    @Override
    public BanktellerDetail getBanktellerByEmail(String email) {
          Bankteller bankteller = 
              em.createNamedQuery("Bankteller.findByEmail", Bankteller.class)
              .setParameter("email", email)
              .getSingleResult();
      return createBantktellerDetail(bankteller);
    }

    @Override
    public Collection<TransactionDetail> getTransactionDetails(int accountId) {
        
        Account sourceAccount = em.find(Account.class, accountId);
        
        Collection<Transaction> transactions = em.createNamedQuery("Transaction.findBySourceAccount")
                .setParameter("sourceAccount", sourceAccount)
                .getResultList();
        
        return createTransactionDetails(transactions);
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
