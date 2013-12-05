/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dk.candycrushers.control.BankManager;
import dk.candycrushers.dto.AccountDetail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas
 */
@WebServlet(name = "AjaxAccountController", urlPatterns = {"/AjaxAccountController"})
public class AjaxAccountController extends HttpServlet {
    
    @EJB
    private BankManager bank;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response
            ) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String key = request.getParameter("command");
        if ("check-account".equals(key)) {
            String id = request.getParameter("accountId");
            long accid = Integer.parseInt(id);
            AccountDetail account = bank.getAccount(accid);
            if (account == null) out.print("false");
            else out.print("true");
        }
        else 
            out.print("unknown command");
        }
    }
