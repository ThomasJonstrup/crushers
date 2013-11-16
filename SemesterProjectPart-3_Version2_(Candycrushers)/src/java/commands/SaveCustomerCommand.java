/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.dto.CustomerDetail;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class SaveCustomerCommand extends TargetCommand{
//    private Customer cusChanged;
    private CustomerDetail cusChanged;

    public SaveCustomerCommand(String target, SecurityRole role) {
        super(target, role);
    }


    @Override
    public String execute(HttpServletRequest request) {
    String customerId = request.getParameter("customerId");
    int id = Integer.parseInt(customerId);
    long idLong = id;
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
//    String password = request.getParameter("password");

        cusChanged = Factory.getInstance().getBank().updateCustomer(idLong, firstName, lastName, email);
        
        request.setAttribute("customer", cusChanged);
        
        return super.execute(request);
    }
 
}
