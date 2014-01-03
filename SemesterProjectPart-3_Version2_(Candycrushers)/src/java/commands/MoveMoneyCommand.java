/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.candycrushers.dto.AccountDetail;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
        
        AccountDetail moneyTransfer = Factory.getInstance().getBank().transactionToAnOtherAccount(fromAcountId, toAcountId, amount);

        return super.execute(request);
    }
}
