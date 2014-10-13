/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "CourseLoginSelector", urlPatterns = {"/CourseLoginSelector"})
public class CourseLoginSelector extends HttpServlet {

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
        ArrayList<Course> courses = null;
                
        try {
             courses = DBAccess.getCourses();
        } catch (SQLException ex) {
            Logger.getLogger(CourseIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("    <head>");
            out.println("        <title>TODO supply a title</title>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Blue.css\">");
            out.println("    </head>");
            out.println("    <body>");
            out.println("	<center>");
            out.println("           <div id=\"Container\">");
            out.println("               <img class=\"main_logo\" src=\"https://lumentouch.com/web_disk/1-1/LumenTouch2013/images/lumen_touch_logo.png\" alt=\"Logo\">");
            out.println("           <div id=\"main_conatiner\">");
            out.println("               <table style=\"width:95%;\" cellpadding=\"0\" cellspacing=\"0\">");
            out.println("                   <tr>");
            out.println("                       <td colspan=\"1\" style=\"\">");
            out.println("                           <h1 style=\"margin:0;padding:0;\">Class Title</h1>");
            out.println("                       </td>");
            out.println("                       <td colspan=\"1\" style=\"\">");
            out.println("                           <h1 style=\"margin:0;padding:0;\">Date</h1>");
            out.println("                       </td>");
            out.println("                       <td colspan=\"1\" style=\"\">");
            out.println("                           <h1 style=\"margin:0;padding:0;\">Enrollment</h1>");
            out.println("                       </td>");
            out.println("                       <td colspan=\"1\" style=\"\">");
            out.println("                           <h1 style=\"margin:0;padding:0;\">Select</h1>");
            out.println("                       </td>");
            out.println("                   </tr>");

            for(int i = 0; i < courses.size(); i++) {
                Course cs = courses.get(i);
                out.println("               <tr>");
                out.println("                   <td style=\"width:500px;vertical-align:top;\">");
                out.println(                        cs.title + "");
                out.println("                   </td>");
                out.println("                   <td style=\"width:200px;vertical-align:top;\">");
                out.println(                        cs.date + "");
                out.println("                   </td>");
                out.println("                   <td style=\"width:200px;vertical-align:top;\">");
                out.println(                        cs.enrolled + "/" + cs.maximum + "");
                out.println("                   </td>");
                out.println("                   <td style=\"width:200px;vertical-align:top;\">");
                out.println("                       <form name=\"input\" action=\"/LumenTouchProject/LoginUser\" method=\"post\">");
                out.println("                           <input type=\"hidden\" name=\"ClassID\" value=\"" + cs.id + "\">");
                out.println("                           <input type=\"submit\" value=\"Select\">");
                out.println("                       </form>");
                out.println("                   </td>");
                out.println("               </tr>");
            }
            
            out.println("               </table>");
            out.println("		</div>");
            out.println("                   <img id=\"footer_img\" src=\"https://lumentouch.com/web_disk/1-1/LumenTouch2013/images/powered_by_lumen_touch.png?un=25144917\">");
            out.println("		</div>");
            out.println("           </center>");
            out.println("       </body>");
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
