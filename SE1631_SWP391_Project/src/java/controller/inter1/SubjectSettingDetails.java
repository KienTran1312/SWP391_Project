/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.inter1;

import dal.SubjectSettingDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SubjectSetting;

/**
 *
 * @author dell
 */
@WebServlet(name="SubjectSettingDetails", urlPatterns={"/SubjectSettingList/SubjectSettingDetails"})
public class SubjectSettingDetails extends HttpServlet {
   
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
            out.println("<title>Servlet SubjectSettingDetails</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectSettingDetails at " + request.getContextPath () + "</h1>");
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
        SubjectSettingDBContext sets = new SubjectSettingDBContext();
        int ssid = Integer.parseInt(request.getParameter("ssid"));
        SubjectSetting s = new SubjectSetting();
        s.setSettingId(ssid);
        request.setAttribute("sub", sets.getSubjectSettingList(s));
        request.getRequestDispatcher("/view/SubjectSettingDetail.jsp").forward(request, response);
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
        SubjectSettingDBContext sets = new SubjectSettingDBContext();
        SubjectSetting s = new SubjectSetting();
        int ssid = Integer.parseInt(request.getParameter("ssid"));
        String svalue = request.getParameter("value");
        String stitle = request.getParameter("title");
        int status = Integer.parseInt(request.getParameter("status"));
        String description = request.getParameter("description");
        
        Boolean status_value = false;
        if (status == 1) {
            status_value = true;
        }
        
        s.setSettingId(ssid);
        s.setSettingValue(svalue);
        s.setSettingTitle(stitle);
        s.setStatus(status_value);
        s.setDescription(description);
        
        sets.updateSubjectSettingDetails(s);
        request.setAttribute("mess", "Update successfuly! ");
        request.getRequestDispatcher("/view/SubjectSettingDetail.jsp").forward(request, response);
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
