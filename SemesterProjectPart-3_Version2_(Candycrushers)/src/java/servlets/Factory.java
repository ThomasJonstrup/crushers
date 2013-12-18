/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import commands.*;
import dk.candycrushers.control.BankManager;
import dk.candycrushers.dto.AccountDetail;
import dk.candycrushers.dto.CustomerDetail;
import dk.candycrushers.dto.CustomerSummary;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
    
    
    private BankManager bank = lookupBankManagerBeanRemote();
 
    

//    private BankManager bank = new DummyBank();
    private static Factory instance = null;
    private Map<String, Command> commands = new HashMap<>();

    private Factory() 
    {
        //All
        commands.put("main", new TargetCommand("/all/main.jsp", SecurityRole.All));
//        commands.put("login_command", new LoginCommand("/all/main.jsp", SecurityRole.All));
        commands.put("show_login", new ShowLoginCommand("login.jsp", SecurityRole.All));
        Map<SecurityRole, String> targetRoles = new HashMap<>();
        targetRoles.put(SecurityRole.Customers, "/all/main.jsp");
        targetRoles.put(SecurityRole.Banktellers, "/all/main.jsp");
        commands.put("login_command", new LoginCommand2(targetRoles, "login.jsp"));

        commands.put("cancel", new TargetCommand("/all/main.jsp", SecurityRole.All));
        commands.put("transactions", new ShowTransactionCommand("/all/transaction.jsp", SecurityRole.All));
        commands.put("show_currency", new TargetCommand("/all/currency.jsp", SecurityRole.All));
        
        //Banktellers
        commands.put("show_date", new ShowDateCommand("show_date.jsp", SecurityRole.Banktellers));
        commands.put("show_customers", new ShowCustomersCommand("/banktellers/show_customers.jsp", SecurityRole.Banktellers));
        commands.put("show_account", new ShowCustomerAccountCommand("/all/account.jsp", SecurityRole.All));
        commands.put("add_customer_target", new TargetCommand("/banktellers/add_customer.jsp", SecurityRole.Banktellers));
        commands.put("add_customer", new AddCustomerCommand("/banktellers/view_customer.jsp", SecurityRole.Banktellers));
        commands.put("logout_command", new LogoutCommand2("login.jsp", SecurityRole.All));
        commands.put("edit_customer", new EditCustomerCommand("/banktellers/edit_customer.jsp", SecurityRole.Banktellers));
        commands.put("create_account", new TargetCommand("/banktellers/createAccount.jsp", SecurityRole.Banktellers));
        commands.put("create_money_account", new TargetCommand("/banktellers/create_money_account.jsp", SecurityRole.Banktellers));
        commands.put("add_account", new CreateNewAccountCommand("/all/account.jsp", SecurityRole.All));
        commands.put("view_customer", new ShowCustomerCommand("/banktellers/view_customer.jsp", SecurityRole.Banktellers));
        commands.put("save_customer", new SaveCustomerCommand("/banktellers/view_customer.jsp", SecurityRole.Banktellers));
//        commands.put("add_bankteller", new AddBankTellerCommand("add_bankteller.jsp", SecurityRole.Banktellers));
//        commands.put("show_banktellers", new ShowBankTellersCommand("show_banktellers.jsp"));
        
        //Customers
        commands.put("show_own_account", new ShowCustomersOwnAccountCommand("/all/account.jsp", SecurityRole.All));
        commands.put("move_money", new MoveMoneyCommand("/all/main.jsp", SecurityRole.All));
        
        
        //Mobile
        commands.put("login_command_mobile", new LoginCommand2(targetRoles, "/MobileA/login.jsp"));
                commands.put("bank_main_mobile", new TargetCommand("/MobileA/BankMain.jsp", SecurityRole.All));
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
      cmdStr = "show_login";
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

    private BankManager lookupBankManagerBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BankManager) c.lookup("java:global/CandyCrusherBackend/BankManagerBean!dk.candycrushers.control.BankManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
