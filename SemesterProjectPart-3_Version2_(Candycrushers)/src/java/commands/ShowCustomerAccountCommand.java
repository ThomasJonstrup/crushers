/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.dto.CustomerDetail;
import javax.servlet.http.HttpServletRequest;
import dummy.model.Customer;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class ShowCustomerAccountCommand extends TargetCommand {

    public ShowCustomerAccountCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
//        request.setAttribute("account", Factory.getInstance().getBank().getAccount());
        
        String cusId = request.getParameter("customerId");
        long customerId = Integer.parseInt(cusId);
        CustomerDetail cus = Factory.getInstance().getBank().getCustomer(customerId);
        
        request.setAttribute("currentPerson", cus);
        return super.execute(request);
    }
}
