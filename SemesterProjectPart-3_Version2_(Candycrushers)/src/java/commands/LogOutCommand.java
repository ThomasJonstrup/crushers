/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Rasmus
 */
public class LogOutCommand extends TargetCommand{

    public LogOutCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("currentPerson");
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
}
