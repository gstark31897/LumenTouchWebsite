/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ncaps12
 */
@WebServlet(name = "CourseInformation", urlPatterns = {"/CourseInformation"})
public class CourseInformation extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int c = Integer.parseInt(request.getParameter("CourseID"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("   <head>");
            out.println("       <title>TODO supply a title</title>");
            out.println("           <meta charset=\"UTF-8\">");
            out.println("           <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("       <link rel=\"stylesheet\" type=\"text/css\" href=\"Blue.css\">");
            out.println("   </head>");
            out.println("   <body>");
            out.println("   <center>");
            out.println("       <div id=\"Container\">");
            out.println("           <img class=\"main_logo\" src=\"/LumenTouchWebsite/lumen_touch_logo.png\" alt=\"Logo\">");
            out.println("       <div id=\"main_conatiner\" style=\"padding: 5% 5% 5% 15%\">");
            out.println("           <form name=\"input\" action=\"/LumenTouchWebsite/ClassEnrollServlet\" method=\"post\">");
            out.println("               <div style=\"text-align: left;\">");
            out.println("               First name: <input type=\"text\" name=\"firstname\"><br>");
            out.println("               Last name: <input type=\"text\" name=\"lastname\"><br>");
            out.println("               Organization: <input type=\"text\" name=\"organization\"><br>");
            out.println("               Phone number: <input type=\"text\" name=\"phone\" value=\"123-456-7890\"><br>");
            out.println("               Email: <input type=\"text\" name=\"phone\"><br>");
            out.println("               <input type=\"hidden\" name=\"CourseID\" value=\""+ c + "\">");
            out.println("               <input type=\"submit\" value=\"Enroll\">");
            out.println("           </form>");
            out.println("           </div>");
            out.println("               <img id=\"footer_img\" src=\"/LumenTouchWebsite/powered_by_lumen_touch.png\">");
            out.println("           </div>");
            out.println("       </center>");
            out.println("   </body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the); sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
