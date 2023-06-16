<%-- 
    Document   : Mensagem
    Created on : 15/10/2014, 18:48:25
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/registrar.css" rel="stylesheet">   
    </head>
    <body>
        <div id="registrar" >
            <form>
                <% 
                    String mensagem  = (String) request.getAttribute("mensagem").toString();
                    String mensagem2 = (String)request.getAttribute("mensagem2").toString();
                    String mensagem3 = (String)request.getAttribute("mensagem3");
                    
                    if (mensagem != null){
                        out.println("<h1>" + mensagem + "</h1>");
                    }
                    
                    if (mensagem2 != null){  
                        out.println("<h2>" + mensagem2 + "</h2>");
                    }
                    
                    if (mensagem3 != null){
                        out.println("<h1>" + mensagem3 + "</h1>");
                    }
                %>
            </form>
        </div> 

    </body>
</html>
