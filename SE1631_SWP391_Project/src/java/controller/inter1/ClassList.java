/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.inter1;

import dal.ClassDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Classes;
import model.User;

/**
 *
 * @author dell
 */
public class ClassList extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClassList</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClassList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        ClassDBContext classes = new ClassDBContext();

        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        ArrayList<User> ltrainer = classes.getTrainerList();
        ArrayList<Classes> lterm = classes.getTermList();
        ArrayList<Classes> lclass = classes.getClassList(index);

        request.setAttribute("trainer", ltrainer);
        request.setAttribute("lterm", lterm);
        request.setAttribute("classlist", lclass);

        int count = classes.totalPage();
        int total = count / 4;
        if (total % 4 != 0) {
            total++;
        }
        request.setAttribute("endP", total);
        request.getRequestDispatcher("/view/ClassList.jsp").forward(request, response);
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
        ClassDBContext classes = new ClassDBContext();

        String raw_term = request.getParameter("term");
        String raw_trainer = request.getParameter("trainer");
        String raw_status = request.getParameter("status");
        String raw_txt = request.getParameter("txt");

        Integer termId = (raw_term != null && raw_term.length() > 0) ? new Integer(raw_term) : null;
        Integer trainerId = (raw_trainer != null && raw_trainer.length() > 0) ? new Integer(raw_trainer) : null;
        Integer status = (raw_status != null && raw_status.length() > 0) ? new Integer(raw_status) : null;
        String searchtxt = (raw_txt != null && raw_txt.length() > 0) ? raw_txt : null;

        ArrayList<User> ltrainer = classes.getTrainerList();
        ArrayList<Classes> lterm = classes.getTermList();
        ArrayList<Classes> lsearch = classes.filter(termId, trainerId, status, searchtxt);

        request.setAttribute("trainer", ltrainer);
        request.setAttribute("lterm", lterm);
        request.setAttribute("classlist", lsearch);
        request.getRequestDispatcher("/view/ClassList.jsp").forward(request, response);
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
