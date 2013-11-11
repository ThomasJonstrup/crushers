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
public class ShowCustomersCommand extends TargetCommand{

    public ShowCustomersCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("customers", Factory.getInstance().getBank().getCustomers());
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
