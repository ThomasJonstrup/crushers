/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Thomas
 */
public class AddBankTellerCommand extends TargetCommand{

    public AddBankTellerCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String tellerUserFirstName = request.getParameter("firstname");
        String tellerUserLastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Factory.getInstance().getBank().addCustomer(password, password, email, password, 2);
        
        request.setAttribute("banktellers", Factory.getInstance());
        
        return super.execute(request);
    }
    
}
