/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.inter1;

import dal.SubjectDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Subject;
import model.User;

/**
 *
 * @author dell
 */
public class UserDetails extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserDetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserDetails at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        SubjectDBContext dbSubject = new SubjectDBContext();
        UserDBContext dbUser = new UserDBContext();
        int uid = Integer.parseInt(request.getParameter("uid"));
        User u = new User();
        u.setUserId(uid);
        request.setAttribute("user", dbUser.getUserDetails(u));
        request.getRequestDispatcher("/view/UserDetails.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        UserDBContext dbUser = new UserDBContext();
        int uid = Integer.parseInt(request.getParameter("uid"));
        String email = request.getParameter("mail");
        String name = request.getParameter("fname");
        String phoneNumber = request.getParameter("phonenum");
        int status = Integer.parseInt(request.getParameter("status"));
        String note = request.getParameter("note");
        
        Boolean status_value = false;
        if (status == 1) {
            status_value = true;
        }
        
        User u = new User();
        u.setUserId(uid);
        u.setEmail(email);
        u.setFullname(name);
        u.setMobile(phoneNumber);
        u.setStatus(status_value);
        u.setNote(note);
        
        dbUser.updateSubjectDetails(u);
        request.setAttribute("mess", "Update successfuly! ");
        request.getRequestDispatcher("/view/UserDetails.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
