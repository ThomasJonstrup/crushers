/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import dummy.model.Customer;
import dummy.model.Person;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Rasmus
 */
public class LoginCommand extends TargetCommand{

    public LoginCommand(String target, SecurityRole role) {
        super(target, role);
    }


    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Person currentPerson = Factory.getInstance().getBank().checkLogin(username, password);
        
        if(currentPerson != null){
            request.getSession().setAttribute("currentPerson", currentPerson);
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
        }
        
        request.getSession().setAttribute("username", username);
        return "/login.jsp";
    }
}
