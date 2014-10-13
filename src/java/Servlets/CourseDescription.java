/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gavinstark
 */
@WebServlet(name = "CourseDescription", urlPatterns = {"/CourseDescription"})
public class CourseDescription extends HttpServlet {

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
        
        int c = Integer.parseInt(request.getParameter("CourseID"));
        Course cs = null;
        try {
            cs = DBAccess.getClass(c);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDescription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <title>TODO supply a title</title>");
            out.println("           <meta charset=\"UTF-8\">");
            out.println("           <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("           <link rel=\"stylesheet\" type=\"text/css\" href=\"Blue.css\">");
            out.println("       </title>");
            out.println("   </head>");
            out.println("   <body style=\"font-family: Arial\">");
            out.println("       <center>");
            out.println("           <div id=\"Container\">");
            out.println("               <img style=\"margin-right: 44%;z-index: 90;margin-bottom:-3px;\" src=\"/LumenTouchProject/lumen_touch_logo.png\" alt=\"Logo\">");
            out.println("           <div id=\"main_conatiner\">");
            out.println("               <h1>" + cs.title + "</h1>");
            out.println("               <p class=\"DescriptionContainer\">" + cs.description + "</p>");
            out.println("               <div class=\"DescriptionContainer\">");
            out.println("               <p><strong>Date:</strong>" + cs.date + "<p>");
            out.println("               <p><strong>Teacher:</strong>" + cs.teacher + "</p>");
            out.println("               <p><strong>Class Space:</strong>" + cs.enrolled + "/" + cs.maximum + "</p>");
            out.println("               <p><strong>Location:</strong>" + cs.location + "</p>");
            out.println("               </div>");
            out.println("               <br/>");
            out.println("               <form name=\"input\" action=\"/LumenTouchProject/UserCredentials\" method=\"post\">");
            out.println("                   <input type=\"hidden\" name=\"CourseID\" value=\"" + c + "\">");
            out.println("                   <input type=\"submit\" value=\"Enroll\">");
            out.println("               </form><br/>");
            out.println("               <form name=\"input\" action=\"/LumenTouchProject/CourseIndex\" method=\"post\">");
            out.println("                   <input type=\"submit\" value=\"Back\">");
            out.println("               </form>");
            out.println("               </div>");
            out.println("                   <img id=\"footer_img\" src=\"/LumenTouchProject/powered_by_lumen_touch.png\">");
            out.println("               </div>");
            out.println("       </center>");
            out.println("   </body>");
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
