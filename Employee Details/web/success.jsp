
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
   padding-top: 200px;
 }
 .form
{
  padding: 30px 20px 30px 20px;
    width: 60%;
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
   width:60%;
    padding:12px 28px;
    margin:8px 26px;
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
           <header> <h1>EMPLOYEE DETAILS</h1></header>
        <center>
<div id="n" class="n" >
<form action="http://localhost:8087/Employee_Details/index.html" method="post" class="form" onsubmit="return validation()">
   
<fieldset class="field">


       SUCCESS!!
        
</fieldset>
    <br/>
 <input class="button" name="submit" type="submit"  value="BACK"/>

</form>
</div>
  
        </center> 
    </body>
</html>
