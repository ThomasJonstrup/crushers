/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.*;
import dk.candycrushers.control.BankManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dummy.model.Customer;
import dummy.control.DummyBank;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Thomas
 */
public class Factory {

    

    private BankManager bank = new DummyBank();
    private static Factory instance = null;
    private Map<String, Command> commands = new HashMap<>();

    private Factory() 
    {
        //All
        commands.put("main", new TargetCommand("/all/main.jsp", SecurityRole.All));
        commands.put("login_command", new LoginCommand("/all/main.jsp", SecurityRole.All));
        commands.put("cancel", new TargetCommand("/all/main.jsp", SecurityRole.All));
        
        //Banktellers
        commands.put("show_date", new ShowDateCommand("show_date.jsp", SecurityRole.Banktellers));
        commands.put("show_customers", new ShowCustomersCommand("/banktellers/show_customers.jsp", SecurityRole.Banktellers));
        commands.put("show_account", new ShowCustomerAccountCommand("/all/account.jsp", SecurityRole.All));
        commands.put("add_customer_target", new TargetCommand("/banktellers/add_customer.jsp", SecurityRole.Banktellers));
        commands.put("add_customer", new AddCustomerCommand("/banktellers/view_customer.jsp", SecurityRole.Banktellers));
        commands.put("logout_command", new LogOutCommand("login.jsp", SecurityRole.Banktellers));
        commands.put("edit_customer", new EditCustomerCommand("/banktellers/edit_customer.jsp", SecurityRole.Banktellers));
        commands.put("create_account", new TargetCommand("/banktellers/createAccount.jsp", SecurityRole.Banktellers));
        commands.put("add_account", new CreateNewAccountCommand("/all/account.jsp", SecurityRole.All));
        commands.put("view_customer", new ShowCustomerCommand("/banktellers/view_customer.jsp", SecurityRole.Banktellers));
        commands.put("save_customer", new SaveCustomerCommand("/banktellers/view_customer.jsp", SecurityRole.Banktellers));
//        commands.put("add_bankteller", new AddBankTellerCommand("add_bankteller.jsp", SecurityRole.Banktellers));
//        commands.put("show_banktellers", new ShowBankTellersCommand("show_banktellers.jsp"));
        
        //Customers
        commands.put("show_own_account", new ShowCustomersOwnAccountCommand("/all/account.jsp", SecurityRole.Customers));
        commands.put("move_money", new MoveMoneyCommand("/all/main.jsp", SecurityRole.All));
            }

    public static Factory getInstance() 
    {
        if (instance == null) instance = new Factory();
        return instance;
    }
    
    public BankManager getBank() { return bank; }
    
    
    
//    public Command getCommand(String commandString)
//    {
//        if(commandString == null)
//        {
//            commandString = "main";
//        }
//        return commands.get(commandString);
//    }

public Command getCommand(String cmdStr, HttpServletRequest request) {
    if (cmdStr == null) {
      cmdStr = "main";
    }
    Command cmd = commands.get(cmdStr);

    //This is the most important place in terms of security
    //If you fail here your security is broken
    if (cmd instanceof TargetCommand) {
      SecurityRole requiredRole = ((TargetCommand) cmd).getRole();
      if (requiredRole != SecurityRole.All
              && !request.isUserInRole(requiredRole.toString())) {
        {
          throw new SecurityException("You don't have the necessary rights for this operation");
        }
      }
    }

    return cmd;
  } 
}
