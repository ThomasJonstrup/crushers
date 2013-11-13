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
import dk.candycrushers.model.Account;
import dk.candycrushers.model.Groups;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.nio.fs.AbstractFileTypeDetector;

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
        Query q = em.createNamedQuery("Customer.findByCustomerId");

        q.setParameter("id", id);

        Customer cus = (Customer) q.getSingleResult();

        CustomerDetail cDetail = new CustomerDetail(cus.getCustomerId(), cus.getFirstName(), cus.getLastName(), cus.getEmail());

        return createCustomerDetail(cus);

    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public CustomerDetail addCustomer(String firstName, String lastName, String email, String password, int role) {
        Customer customer;
        customer = new Customer(firstName, lastName, email, password, role);
        Query query = em.createNamedQuery("Groups.findByGroupName");
        query.setParameter("groupName", "Customers");
        Groups group = (Groups) query.getSingleResult();
        em.persist(customer);
        return createCustomerDetail(customer);
    }

    @Override
    public void addAccount(AccountDetail account) {
        Account acc;
        Integer i = (int) account.getAccountId();
        acc = new Account(i, account.getAccountType());
        Query query = em.createNamedQuery("Account.findByAccountId");
        em.persist(acc);
        
        
    }

    @Override
    public CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email, String password) {
        long id = customerID;
        Customer cust;
        if (id == 0) {
            cust = new Customer(0, firstName, lastName, email, password);
            em.persist(cust);
        } else {
            cust = em.find(Customer.class, (int) id);
            cust.setFirstName(firstName);
            cust.setLastName(lastName);
            cust.setEmail(email);
            cust.setPassword(password);
        }
        return createCustomerDetail(cust);
    }

    @Override
    public AccountDetail getAccount() {
        Query q = em.createNamedQuery("Account.findByAccountId");
       
        Account acc = (Account) q.getSingleResult();

        AccountDetail aDetail = new AccountDetail(acc.getAccountId(), acc.getAccountType(), acc.getBalance(), acc.getOwner());

        return createAccountDetail(acc);

    }

    @Override
    public String transactionToAnOtherAccount(int fromAccountId, int toAccountId, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDetail getAccountTransactionToEachOther(long accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
