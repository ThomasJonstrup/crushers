/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.dto.CustomerDetail;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class AddCustomerCommand extends TargetCommand { // Arver fra TargetCommand

    public AddCustomerCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String userFirstName = request.getParameter("firstName");
        String userLastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        CustomerDetail newCustomer = Factory.getInstance().getBank().addCustomer(userFirstName, userLastName, email, password, 1);
                
        request.setAttribute("customer", newCustomer);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
