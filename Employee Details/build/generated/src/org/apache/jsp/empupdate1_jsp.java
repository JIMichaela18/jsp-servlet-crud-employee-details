package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Connection;

public final class empupdate1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");

Class.forName("com.mysql.jdbc.Driver");
                Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetails", "root", "");
                String eid=request.getParameter("eid");
                String query = "select * from empinfo where eid='"+eid+"'";
             Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query);
            while(rs.next())
                {  
                    String eeid=rs.getString("eid");
                    int age=rs.getInt("age");
                    int salary=rs.getInt("salary");
                    String exp=rs.getString("exp");
                
      out.write("\n");
      out.write("                \n");
      out.write("<form action=\"http://localhost:8087/Employee_Details/empupdate\" method=\"post\" class=\"form\" >\n");
      out.write("                  <table><tr>\n");
      out.write("                      <tr><tr><td>Age</td><td><input type=\"number\" name=\"age\" value=\"");
      out.print(age);
      out.write("\"></td></tr>\n");
      out.write("                 <tr><tr><td>Salary</td><td><input type=\"text\" name=\"salary\" value=\"");
      out.print(salary);
      out.write("\"></td></tr>                \n");
      out.write("              <tr><tr><td>Experience</td><td><input type=\"text\" name=\"exp\" value=\"");
      out.print(exp);
      out.write("\"></td></tr>\n");
      out.write("                  </tr></table>\n");
      out.write("                  <input type=\"button\" name=\"submit\" value=\"update\" onClick=\"JavaScript:window.location='http://localhost:8087/Employee_Details/empupdate';\">\n");
      out.write("          </form>\n");
      out.write("                 ");
 
                 }

                  /*
        String x=request.getParameter("submit");
onclick="<jsp:forward page = "http://localhost:8087/Employee_Details/empupdate"/>"
        if (x.equals("update")){ 
            request.sendRedirect("http://localhost:8087/Employee_Details/empupdate");
}*/
                  
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
