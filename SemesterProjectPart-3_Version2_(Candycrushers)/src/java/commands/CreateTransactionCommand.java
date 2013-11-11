/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Thomas
 */
public class CreateTransactionCommand extends TargetCommand{

    public CreateTransactionCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
