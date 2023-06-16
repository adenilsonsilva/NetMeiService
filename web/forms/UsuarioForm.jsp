<%-- 
    Document   : Mensagem
    Created on : 15/10/2014, 18:48:25
    Author     : Cliente
--%>

<%@page import="java.sql.Date"%>
<%@page import="br.com.bitnet.util.Global"%>
<%@page import="br.com.bitnet.dao.UsuarioDao"%>
<%@page import="br.com.bitnet.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> --%>
        <script class="jsbin" src="../js/jquery-1.8.3.min.js"></script>
         <link href="../css/forms.css" rel="stylesheet">   
        <style type="text/css">
            img {width:100px;}
        </style>
        
            <script>
                function myFunction() {
                    var myWindow = window.open("UsuarioImagem.jsp", "myWindow", "width=450, height=450");
                   // myWindow.document.write("<p>This is 'myWindow'</p>");
                   //opener.location.reload();
                   // window.close();

                   // myWindow.opener.document.write("<p>This is the source window!</p>");
                }
          </script>
    </head>
    <body>
        
        <%           
            Date data = new java.sql.Date(1,1,1);
            
            Usuario usuario = new Usuario(0, Global.idEmpresa, "", "","",data, false, "");                    
                    
            String esconderImagem = "hidden";
            String ativo = "checked";
            
            if (request.getParameter("idusuario")!=null){
                UsuarioDao usuarioDao = new UsuarioDao();
                usuario = usuarioDao.getObjeto(Integer.parseInt(request.getParameter("idusuario")));
                session.setAttribute("usuarioImagem", usuario);
                esconderImagem = "";
                if (usuario.getAtivo()){
                    ativo = "checked";
                }else{
                    ativo = "";
                }
              
            }
            
        %>
        <div id="registrar">
            <div id="triangle"></div>
            <h1>Usuario</h1>
            <form action="RegistrarServlet" method="POST">
                <div id="usuario">              
                    <a <%=esconderImagem%> href="#" onclick="myFunction();"><img  title="Alterar Imagem" id="uploadPreview1" src="..images/user.png" /></a>
                   
                    <input  <%=esconderImagem%> type="text" placeholder="código" name="idusuario" disabled="disabled" required="required" title="" value="<%=usuario.getIdusuario()%>" />
                    <input type="text" placeholder="Nome" name="mome" required="required" title="" value="<%=usuario.getNome()%>"/>
                    <input type="email" placeholder="Email" name="email" required="required" title="" value="<%=usuario.getEmail()%>"/>
                    <input type="password" placeholder="Senha" name="senha" required="required" title="" value="<%=usuario.getSenha()%>"/>                   
                    <input type="checkbox" name="ativo"  checked="checked" title="Ativo" value="ON" checked="<%=ativo%>" />Ativo

                    <input type="submit" value="Salvar"  /> 
                </div>
            </form>
        </div>  
   

    </body>
</html>
