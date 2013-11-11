/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thomas
 */
public class BankTeller extends Person{
    
    private long banktellerid;
    private static int nextId = 1000;

    public BankTeller(String firstName, String lastName, String email, String password, int role) {
        super(firstName, lastName, email, password, role);
//        this.banktellerid = banktellerid;
        this.banktellerid = nextId++;
    }

    public long getBanktellerid() {
        return banktellerid;
    }

    public static int getNextId() {
        return nextId;
    }
    
}
