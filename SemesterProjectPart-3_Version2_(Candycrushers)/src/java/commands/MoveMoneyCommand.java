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
public class MoveMoneyCommand extends TargetCommand{

    public MoveMoneyCommand(String target, SecurityRole role) {
        super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        int fromAcountId = Integer.parseInt(request.getParameter("fromAccountId"));
        int toAcountId = Integer.parseInt(request.getParameter("toAcountId"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        
        String moneyTransfer = Factory.getInstance().getBank().transactionToAnOtherAccount(fromAcountId, toAcountId, amount);
//        Person currentPerson = Factory.getInstance().getBank().checkLogin(username, password);
        
//        if(currentPerson != null){
//            request.getSession().setAttribute("currentPerson", currentPerson);
//        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
//        }
        
//        request.getSession().setAttribute("username", username);
        return super.execute(request);
    }
}
