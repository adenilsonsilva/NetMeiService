<%-- 
    Document   : ConfirmaAcesso
    Created on : 16/10/2014, 14:59:22
    Author     : Cliente
--%>

<%@page import="br.com.bitnet.dao.UsuarioDao"%>
<%@page import="br.com.bitnet.dao.GenericDao"%>
<%@page import="br.com.bitnet.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%  UsuarioDao usuarioDao = new UsuarioDao();
           GenericDao genericDao = new GenericDao();
        
           int idUsuario = Integer.parseInt(request.getParameter("cod"))/853 ;
           Usuario usuario = usuarioDao.getObjeto(idUsuario);
          
           if (usuario != null){ 
               usuario.setAtivo(true);
               genericDao.atualizar(usuario);

               response.sendRedirect("Login.jsp");
           }
       %>
    </body>
</html>
