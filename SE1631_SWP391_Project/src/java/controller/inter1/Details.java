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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Subject;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name="Details", urlPatterns={"/SubjectList/Details"})
public class Details extends HttpServlet {
   
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
            out.println("<title>Servlet Details</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Details at " + request.getContextPath () + "</h1>");
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
        int sid = Integer.parseInt(request.getParameter("sid"));
        Subject s = new Subject();
        s.setSubjectId(sid);
        ArrayList<User> lu = dbUser.getManagerList();
        ArrayList<User> lm = dbUser.getExpertList();
        request.setAttribute("user", lu);
        request.setAttribute("manager", lm);
        request.setAttribute("sub", dbSubject.getSubjectList(s));
        request.getRequestDispatcher("/view/SubjectDetail.jsp").forward(request, response);
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
        SubjectDBContext dbSubject = new SubjectDBContext();
        int sid = Integer.parseInt(request.getParameter("sid"));
        String scode = request.getParameter("scode");
        String sname = request.getParameter("sname");
        int status = Integer.parseInt(request.getParameter("status"));
        int manager_id = Integer.parseInt(request.getParameter("manager"));
        int expert_id = Integer.parseInt(request.getParameter("expert"));
        String description = request.getParameter("description");
        
        Boolean status_value = false;
        if (status == 1) {
            status_value = true;
        }
        
        Subject s = new Subject();
        s.setSubjectId(sid);
        s.setSubjectCode(scode);
        s.setSubjectName(sname);
        s.setStatus(status_value);
        s.setManagerId(manager_id);
        s.setExpertId(expert_id);
        s.setBody(description);
        
        dbSubject.updateSubjectDetails(s);
        request.setAttribute("mess", "Update successfuly! ");
        request.getRequestDispatcher("/view/SubjectDetail.jsp").forward(request, response);
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
