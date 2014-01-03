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
public class AboutCommand extends TargetCommand{

    public AboutCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String user = request.getRemoteUser();
        if(user != null) {
            if(request.isUserInRole("Banktellers"))
            {
                System.out.println("This is a Bankteller");
                request.setAttribute("msg", "Banktellers");
                 int num = Factory.getInstance().getBank().getCustomerCount();
                request.setAttribute("count", num);
            }else if (request.isUserInRole("Customers")){
                System.out.println("This is a Customer");
                request.setAttribute("msg", "Customers");
                    int bnum = Factory.getInstance().getBank().getBanktellerCount();
                    request.setAttribute("countBank", bnum);
            } else {
                System.out.println("You are not logged in");
                request.setAttribute("msg", "");
            }
                    
        }
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
