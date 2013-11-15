
package commands;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import javax.servlet.ServletException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class LoginCommand2 implements Command {
    
    private final Map<SecurityRole, String> roleToTarget;
    private final String loginFailed;

    public LoginCommand2(Map<SecurityRole, String> targetRoles, String loginFailedPage) {
        this.roleToTarget = targetRoles;
        this.loginFailed = loginFailedPage;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        String nextPage = loginFailed;
        
    try {
      request.login(userName, password);
      
      if(request.isUserInRole("Customers")) {
          System.out.println("User is customer");
      }else
      
      if(request.isUserInRole("Banktellers")) {
          System.out.println("User is banktellers");
      }else
            System.out.println("unkhown roles");
      
      for (SecurityRole role : roleToTarget.keySet()) {
        if(request.isUserInRole(role.toString())){
          nextPage = roleToTarget.get(role);
          break;
        }
      }
    } 
    catch (ServletException ex) {
      request.setAttribute("loginerror", "You failed to login");
      Logger.getLogger(LoginCommand2.class.getName()).log(Level.SEVERE, null, ex);
    }
    return nextPage;
  }
   
}
