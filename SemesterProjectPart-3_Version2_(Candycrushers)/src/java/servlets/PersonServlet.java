package servlets;

/*
 */

import client.KrakClient;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import model.Person;

/**
 *
 * @author Thomas
 */
@WebServlet(urlPatterns = {"/PersonServlet"})
public class PersonServlet extends HttpServlet {

  Map<String,Person> persons ;
  
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("application/json;charset=UTF-8");
    String phone = request.getParameter("phone");
    if(persons == null){
      init();
    }
    
      KrakClient krak = new KrakClient();
      String find_JSON = krak.find_JSON(String.class, phone);
    
    Person p = persons.get(phone);
    String json =new Gson().toJson(p);
    try (PrintWriter out = response.getWriter()) {
      out.println(find_JSON);
    }
  }
  
  public void init(){
    persons  = new HashMap();
    
    Address a = new Address("Nørrebrogade","Købehavn","2200");
    Person p = new Person("Thomas","Rasmussen",25000.25d,"peter@hotmail.com",a);
    persons.put("12345678", p);
    
    a = new Address("Lyngbyvej 22","Lyngby","2800");
    p = new Person("Peter","Hansen",25000.25d,"ph@gamil.com",a);
    persons.put("22222222", p);
  }
  

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
  
}
