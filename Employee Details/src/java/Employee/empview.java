/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class empview extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet empview</title>");   
            out.println("<style>\n" +
"                        header \n" +
"{\n" +
"    padding-left: 3%;\n" +
"    top:0;\n" +
"    left: 0;\n" +
"    position: fixed;\n" +
"    background-color:black;\n" +
"    opacity: 0.8;\n" +
"    width:100%;\n" +
"    display:flex;\n" +
"    color: antiquewhite;\n" +
"}\n" +
" .n\n" +
"{\n" +
"  padding: 200px 200px 80px 200px;\n" +
"    width: 60%;\n" +
"    height: 60%;\n" +
"    overflow: auto;\n" +
"    background-color: white;\n" +
"}\n" +
".table\n" +
"{\n" +
            
"    background-color: tomato;\n" +
"    padding:80px 30px 80px 30px;\n" +
"    border-radius: 12%;\n" +
"}   \n" +
".input\n" +
"{\n" +
"   width:60%;\n" +
"    padding:12px 28px;\n" +
"    margin:8px 26px;\n" +
"    display:inline-block;\n" +
"    border:2px;\n" +
"    box-sizing: border-box;\n" +
"    font-size: 16px;\n" +
"    border-radius: 15%;\n" +
"}\n" +
".button\n" +
"{\n" +
"    background-color:tomato;\n" +
"    color:whitesmoke;\n" +
"    padding:10px 20px;\n" +
"    margin:8px 26px;\n" +
"    border: none;\n" +
"    cursor: pointer;\n" +
"    width:50%;\n" +
"    font-size:20px;\n" +
"    border-radius: 15%;\n" +
"}\n" +
".button:hover\n" +
"{\n" +
"    opacity:0.8;\n" +
"}\n" +
"\n" +
"            </style>\n" +
"    </head>");
            out.println("</head>");
            out.println("<body>");
  out.println(" <header> <h1>EMPLOYEE DETAILS [VIEW]</h1></header>\n" +
"        <center><div class='n'>");
          out.println("<table border='1' cellspacing='40px'>"); 
        
            try
        {
             
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails", "root", "");
            
                String eid=request.getParameter("eid");
                Statement stmt= con.createStatement();
                
                ResultSet rs1=stmt.executeQuery("select * from empinfo where eid='"+eid+"'");
               out.println("<table class='table'><tr><td>Employee Id</td><td>Name</td><td>Department</td><td>Age</td><td>Gender</td>" +
                       "<td>Address</td><td>Nationality</td><td>Contact No</td><td>Email Id</td><td>Experience</td><td>Salary</td></tr>");
                while(rs1.next())
                {      
                        
out.println("<tr><td>"+rs1.getString("eid")+"</td>");
out.println("<td>"+rs1.getString("name")+"</td>");
out.println("<td>"+rs1.getString("dept")+"</td>");
/*out.println("<td>"+rs1.getDate("dob")+"</td>");*/
out.println("<td>"+rs1.getInt("age")+"</td>");
out.println("<td>"+rs1.getString("gender")+"</td>");
out.println("<td>"+rs1.getString("address")+"</td>");
out.println("<td>"+rs1.getString("nat")+"</td>");
out.println("<td>"+rs1.getString("phno")+"</td>");
out.println("<td>"+rs1.getString("emailid")+"</td>");
out.println("<td>"+rs1.getString("exp")+"</td>");
out.println("<td>"+rs1.getString("salary")+"</td>");


                }
                out.println("</tr></table></center>");   
                }catch(ClassNotFoundException | SQLException e)
                        {
                        System.out.println(e.getMessage());
                        }
        
       
          out.println("<a href='index.html' class='button'>BACK</a></div>");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
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
