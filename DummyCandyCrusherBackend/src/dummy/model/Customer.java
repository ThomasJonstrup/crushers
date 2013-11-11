package dummy.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lars Mortensen
 */
public class Customer extends Person{

    private long customerId;
    private static Map<Long, Customer> items = new HashMap<>();
    private List<Account> accounts = new ArrayList();
    private static int nextid = 1000;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Customer(String firstName, String lastName, String email, String password, int role) {
        super(firstName, lastName, email, password, role);
//        this.customerId = customerId;
        this.customerId = nextid++;
    }
    

    public void addAccount(Account account) {
        accounts.add(account);
        account.setOwner(this);
    }

    public static Customer find(long id) {
        return items.get(id);
    }

    public static Collection<Customer> list() {
        return items.values();
    }

}
