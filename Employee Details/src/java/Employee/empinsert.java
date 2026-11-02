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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class empinsert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
    try{   PrintWriter out = response.getWriter(); 
            /* TODO output your page here. You may use following sample code. */
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
            String eid = request.getParameter("eid");
             String name = request.getParameter("name"); 
             String dept = request.getParameter("dept"); 
           
         
             String nat=request.getParameter("nat");
             int age = Integer.parseInt(request.getParameter("age")); 
             String gender = request.getParameter("gender");
             String address= request.getParameter("address");
             String phno = request.getParameter("phno"); 
             String emailid = request.getParameter("emailid");
             String exp = request.getParameter("exp");  
             String salary = request.getParameter("salary");
                     
          int updatequery=0;
          Connection con=null;
          PreparedStatement prep1=null;

                Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails", "root", "");
                
                 Statement stmt= con.createStatement();
                
    ResultSet rs=stmt.executeQuery("select * from empinfo");
    while(rs.next())
                {  
    String dbeid=rs.getString(1);
    if( dbeid.equals(eid))
    {
        out.println("<h1 class='table'>"+"Employee Record Already Exists"+"</h1>");
    }
     
     
              else
    {
        
        String sql1 = "INSERT INTO empinfo(eid,name,dept,age,gender,address,nat,phno,emailid,exp,salary) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        prep1 =   con.prepareStatement(sql1);
        
        prep1.setString(1, eid);
        prep1.setString(2, name);
        prep1.setString(3, dept);
    
        prep1.setInt(4, age);
        prep1.setString(5, gender);
        prep1.setString(6, address);
        prep1.setString(7,nat);
        prep1.setString(8, phno);
        prep1.setString(9, emailid);
        prep1.setString(10, exp);
        prep1.setString(11, salary);
        
        updatequery=prep1.executeUpdate();
        if(updatequery!=0)
        {
           
            
            Statement stmt1= con.createStatement();
            
            ResultSet rs1=stmt1.executeQuery("select * from empinfo WHERE eid ='"+eid+"'");
            
            while(rs1.next())
            {
                
                
                out.println("<table class='table'><tr><td>Employee Id</td><td>Name</td><td>Department</td><td>Age</td><td>Gender</td>"
                        + "<td>Address</td><td>Nationality</td><td>Contact No</td><td>Email Id</td><td>Experience</td><td>Salary</td></tr>");
                out.println("<tr><td>"+rs1.getString("eid")+"</td>");
                out.println("<td>"+rs1.getString("name")+"</td>");
                out.println("<td>"+rs1.getString("dept")+"</td>");
                
                out.println("<td>"+rs1.getInt("age")+"</td>");
                out.println("<td>"+rs1.getString("gender")+"</td>");
                out.println("<td>"+rs1.getString("address")+"</td>");
                out.println("<td>"+rs1.getString("nat")+"</td>");
                out.println("<td>"+rs1.getString("phno")+"</td>");
                out.println("<td>"+rs1.getString("emailid")+"</td>");
                out.println("<td>"+rs1.getString("exp")+"</td>");
                out.println("<td>"+rs1.getString("salary")+"</td>");
                out.println("</tr></table>");
                 out.println("<a href='index.html' class='button'>BACK</a></div>");
                out.println("</body>");
                out.println("</html>");
            }
        }else
        {
          
            response.sendRedirect("error.jsp");
          
        }
    }
prep1.close();
                }
               
    }catch(IOException | ClassNotFoundException | NumberFormatException | SQLException e)
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
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException | ClassNotFoundException ex) {
            Logger.getLogger(empinsert.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException | ClassNotFoundException ex) {
            Logger.getLogger(empinsert.class.getName()).log(Level.SEVERE, null, ex);
        }
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
