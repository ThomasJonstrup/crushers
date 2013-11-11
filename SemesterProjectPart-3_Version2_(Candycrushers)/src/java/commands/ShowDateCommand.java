/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Thomas
 */
public class ShowDateCommand extends TargetCommand {    

    public ShowDateCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("date", new Date());
        return super.execute(request); 
    }
    

}
