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
public class ShowCustomersOwnAccountCommand extends TargetCommand {

    public ShowCustomersOwnAccountCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
//        request.setAttribute("account", Factory.getInstance().getBank().getAccount());
        return super.execute(request);
    }
}
