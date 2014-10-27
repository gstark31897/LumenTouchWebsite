/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import DBUtil.DBAccess;
import DataStructures.User;
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
@WebServlet(name = "VerifyUser", urlPatterns = {"/VerifyUser"})
public class VerifyUser extends HttpServlet {

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
        
        int c = Integer.parseInt(request.getParameter("ClassID"));
        String email = request.getParameter("email");
        System.out.println(email + "IAMANEMAIL");
        User u = null;
        try {
            u = DBAccess.getUser(email);
        } catch (SQLException ex) {
            Logger.getLogger(VerifyUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("   <head>");
            out.println("       <title>Course Index</title>");
            out.println("       <meta charset=\"UTF-8\">");
            out.println("       <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("       <link rel=\"stylesheet\" type=\"text/css\" href=\"Blue.css\">");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <center>");
            out.println("           <div id=\"Container\">");
            out.println("               <img class=\"main_logo\" src=\"/LumenTouchWebsite/lumen_touch_logo.png\" alt=\"Logo\">");
            out.println("               <div id=\"main_conatiner\">");
            out.println("                   <p>Please verify this information:</p>");
            out.println("                   <form name=\"input\" action=\"/LumenTouchWebsite/PrintNametag\" method=\"post\">\n");
            out.println("                       <input type=\"hidden\" name=\"ClassID\" value=\"" + c + "\">\n");
            out.println("                       First Name: <input type=\"text\" name=\"firstname\" value=\"" + u.first_name + "\" ><br>\n");
            out.println("                       Last Name: <input type=\"text\" name=\"lastname\" value=\"" + u.last_name + "\"><br>\n");
            out.println("                       Organization <input type=\"text\" name=\"organization\" value=\"" + u.organization + "\"><br>\n");
            out.println("                       Phone Number: <input type=\"text\" name=\"phonenumber\" value=\"" + u.phone_number + "\"><br>\n");
            out.println("                       <button type=\"submit\">Submit</button>\n");
            out.println("                   </form>\n");
            out.println("               </div>");
            out.println("               <br>");
            out.println("               <img id=\"footer_img\" src=\"/LumenTouchWebsite/powered_by_lumen_touch.png\">");
            out.println("           </div>");
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
