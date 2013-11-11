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
public class ShowBankTellersCommand extends TargetCommand {

    public ShowBankTellersCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("banktellers", Factory.getInstance().getBank().getBankTellers());
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
