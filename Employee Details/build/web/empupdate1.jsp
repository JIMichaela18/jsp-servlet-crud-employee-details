
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            header 
{
    padding-left: 3%;
    top:0;
    left: 0;
    position: fixed;
    background-color:black;
    opacity: 0.8;
    width:100%;
    display:flex;
    color: antiquewhite;
}
 .n{
 padding-left:400px;

 }

 .form
{
  
    border-bottom: 10px;
    padding-top: 20px;
    padding-right: 30px;
    padding-left: 30px;
  color: white;
  padding-bottom: 50px;
    width: 40%;
    height: 60%;
    overflow: auto;
    background-color: rgba(0,0,0,0.8);
}
.field
{
    background-color: tomato;
    padding:20px 10px 20px 10px;
    border-radius: 12%;
}   
.input
{
    padding-right: 20px;
   width:120%;
    padding:12px 28px;
    margin:5px 5px;
    display:inline-block;
    border:2px;
    box-sizing: border-box;
    font-size: 16px;
    border-radius: 15%;
}
.button
{
    background-color:tomato;
    color:whitesmoke;
    padding:10px 20px;
    margin:8px 26px;
    border: none;
    cursor: pointer;
    width:50%;
    font-size:20px;
    border-radius: 15%;
}
.button:hover
{
    opacity:0.8;
}

            </style>
    </head>
    <body>
        
       
        <header> <h1>EMPLOYEE DETAILS [UPDATE]</h1></header>
       <%
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
                    String exp=rs.getString("exp");
                     String salary=rs.getString("salary");
                %><br/><br/><br/><br/><br/><br/>
                <div class="n">
<form action="http://localhost:8087/Employee_Details/empupdate" method="post" class="form" >
    <input type="hidden" name="eid" value="<%=eeid%>">

                  <table class="table"><tr>
                      <tr><tr><td>Age</td><td><input class="input" type="number" name="jage" value="<%=age%>" disabled="true"></td></tr>
                   <tr><tr><td>Experience</td><td><input class="input"  type="text" name="jexp" value="<%=exp%>" disabled="true"></td></tr>
                 <tr><tr><td>Salary</td><td><input class="input"  type="text" name="jsalary" value="<%=salary%>" disabled="true"></td></tr> 
                    </tr></table>
                    <table>
                 <tr><tr><td>Age</td><td><input class="input"  type="number" name="sage" value="sage" ></td></tr>
                   <tr><tr><td>Experience</td><td><input class="input"  type="text" name="sexp"></td></tr>
                   <tr><tr><td>Salary</td><td><input class="input"  type="text" name="ssalary" ></td></tr> 
               
                  </tr></table>
                 <br/>
                    &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                    <input class="button"  type="submit" name="submit" value="update" >
          </form>
                 <%
                     HttpSession sess=request.getSession();
                 
  sess.setAttribute("eeid",eid);             

             }
                  %>
                </div>
    </body>
</html>
