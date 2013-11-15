/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.control.BankManager;
import dk.candycrushers.dto.CustomerDetail;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class ShowCustomerCommand extends TargetCommand {

    public ShowCustomerCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String customerId = request.getParameter("customerId");
        int id = Integer.parseInt(customerId);
        BankManager bank = Factory.getInstance().getBank();
        CustomerDetail customer = bank.getCustomer(id);
        request.setAttribute("customer", customer);
        return super.execute(request); 
    }
    
}
