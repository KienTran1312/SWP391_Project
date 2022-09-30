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
import java.util.List;
import model.Subject;
import model.User;

/**
 *
 * @author dell
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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
        String search = request.getParameter("txt");
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }

        int index = Integer.parseInt(indexPage);
        String managerName = request.getParameter("Manager");
        String expertName = request.getParameter("expert");
        String status = request.getParameter("status");

        if (managerName == null || managerName.length() == 0) {
            managerName = "-1";
        }
        if (expertName == null || expertName.length() == 0) {
            expertName = "-1";
        }
        if (status == null || status.length() == 0) {
            status = "-1";
        }
        if (search == null || search.trim().length() == 0) {
            search = null;
        }

        int mid = Integer.parseInt(managerName);
        int eid = Integer.parseInt(expertName);
//        boolean status_value = Boolean.parseBoolean(status);
        int status_value = Integer.parseInt(status);
        String txt_value = search;

        UserDBContext user = new UserDBContext();
        SubjectDBContext subject = new SubjectDBContext();

        ArrayList<User> lu = user.getManagerList();
        ArrayList<User> lm = user.getExpertList();
        ArrayList<Subject> ls = subject.getStatusList();

        ArrayList<Subject> listSubject = subject.Filter(mid, eid, status_value, txt_value, index);
// ArrayList<Subject> listSubject = subject.Filter(1, 2, true, "oop", 1);
        request.setAttribute("listSubjects", listSubject);
        request.setAttribute("size", listSubject.size() + "");
        request.setAttribute("user", lu);
        request.setAttribute("manager", lm);
        request.setAttribute("status", ls);

        int count = subject.countFilter(mid, eid, status_value, txt_value);
        int total = count / 4;
        if (total % 4 != 0) {
            total++;
        }

        request.setAttribute("search", txt_value + " ");
//        request.setAttribute("Manager", mid + " ");
//        request.setAttribute("expert", eid + " ");
//        request.setAttribute("status", status_value + " ");
        request.setAttribute("endP", total);
        request.getRequestDispatcher("/view/SearchList.jsp").forward(request, response);
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
