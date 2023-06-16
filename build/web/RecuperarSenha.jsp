<%-- 
    Document   : RecuperarSenha
    Created on : 17/10/2014, 19:35:37
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BelAdm Online</title>
        <link href="css/registrar.css" rel="stylesheet">
    </head>
    <body>
           <div id="registrar">
            <div id="triangle"></div>
            <h1>Uma nova senha será enviada para sua conta de email.</h1>
            <form action="RecuperarSenhaServlet" method="POST">
                <div id="usuario">                      
                    <input type="email" placeholder="Email" name="email" required="required" title=""/>
                    <input type="submit" value="Enviar" />   
                </div>
            </form>     
        </div>       
        
    </body>
</html>
