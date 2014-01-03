/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.AccountSummary;
import dk.candycrushers.dto.CustomerDetail;
import javax.servlet.http.HttpServletRequest;
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
//        AccountDetail newAccount = new AccountDetail();
//        newAccount.createTransaction(0, "Konto oprettet!");
        
        String cusId = request.getParameter("customerId");
        long customerId = Integer.parseInt(cusId);
        
        String bal = request.getParameter("balance");
        double balance = Double.parseDouble(bal);
        
        Factory.getInstance().getBank().addAccount(accountType, balance, customerId);
        
        CustomerDetail cus = Factory.getInstance().getBank().getCustomer(customerId);
        
        
        request.setAttribute("currentPerson", cus);

//        cus.addAccount(newAccount);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
