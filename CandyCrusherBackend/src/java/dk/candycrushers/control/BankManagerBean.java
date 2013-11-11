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
import dk.candycrushers.model.Groups;
import java.util.Collection;
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
        Query q = em.createNamedQuery("Customer.findByCustomerId");
        
        q.setParameter("id", id);
        
        Customer cus = (Customer) q.getSingleResult();
        
        CustomerDetail cDetail = new CustomerDetail(cus.getCustomerId(), cus.getFirstName(), cus.getLastName(), cus.getEmail());
        
        return null;
        
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public CustomerDetail addCustomer(String firstName, String lastName, String email, String password, int role) {
        Customer customer;
        
        customer = new Customer(firstName, lastName, email, password, 1);
        Query query = em.createNamedQuery("Groups.findByGroupName");
        query.setParameter("groupName", "Customers");
        Groups group = (Groups)query.getSingleResult();
        em.persist(customer);
        return createCustomerDetail(customer);
        
        
    } 
    
//    @Override
//    public CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    

    @Override
    public void addAccount(AccountDetail account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDetail updateCustomer(long customerID, String firstName, String lastName, String email, String password) {
//        long id = customerdetail.getCustomerId();
//        Customer customer;
//        if (id == 0) {
//            customer = new Customer(
//                    0, 
//                    customerdetail.getFirstName(), 
//                    customerdetail.getLastName(), 
//                    customerdetail.getEmail()
//                    );
//            em.persist(customer);
//            }
//        else {
//            customer = em.find(Customer.class, (int)id);
//            customer.setFirstName(customerdetail.getFirstName());
//            customer.setLastName(customerdetail.getLastName());
//            customer.setEmail(customerdetail.getEmail());
//            }
//        return createCustomerDetail(customer);
        }    
    
}
