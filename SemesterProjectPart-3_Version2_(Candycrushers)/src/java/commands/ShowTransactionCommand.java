/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class ShowTransactionCommand extends TargetCommand {

    public ShowTransactionCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        String accId;
        accId = request.getParameter("accountId");
        int accountId = Integer.parseInt(accId);
        
        ArrayList transactions = (ArrayList) Factory.getInstance().getBank().getTransactionDetails(accountId);
        
        request.setAttribute("transactions", transactions);
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
 
 
}
