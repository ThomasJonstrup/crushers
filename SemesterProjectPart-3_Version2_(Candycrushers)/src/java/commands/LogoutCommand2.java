/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Thomas
 */
public class LogoutCommand2 extends TargetCommand {

    public LogoutCommand2(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        try {
           request.logout();
        } catch (ServletException ex) {
      Logger.getLogger(LogoutCommand2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
