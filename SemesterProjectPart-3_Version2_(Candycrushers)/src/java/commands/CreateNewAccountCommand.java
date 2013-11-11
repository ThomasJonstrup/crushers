/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.dto.CustomerDetail;
import javax.servlet.http.HttpServletRequest;
import dummy.model.Account;
import dummy.model.Customer;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Rasmus
 */
public class CreateNewAccountCommand extends TargetCommand{

    public CreateNewAccountCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String accountType = request.getParameter("accountType");
        Account newAccount = new Account(accountType, 0);
        newAccount.createTransaction(0, "Konto oprettet!");
        Factory.getInstance().getBank().addAccount(newAccount);
        
        String cusId = request.getParameter("customerId");
        long customerId = Integer.parseInt(cusId);
        CustomerDetail cus = Factory.getInstance().getBank().getCustomer(customerId);
        
        request.setAttribute("currentPerson", cus);
        
//        cus.addAccount(newAccount);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
