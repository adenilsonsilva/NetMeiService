<%-- 
    Document   : Mensagem
    Created on : 15/10/2014, 18:48:25
    Author     : Cliente
--%>

<%@page import="br.com.bitnet.bean.Imagens"%>
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
            img {width:150px;}
        </style>
        <script> 
        function closeWin() {
              opener.location.reload();
              Window.close();                                                  // Closes the new window
        }
       </script>

    </head>
    <body>
        
        <% Usuario usuarioImagem = (Usuario) session.getAttribute("usuarioimagem");        
        %>
        
        <div id="registrar">
            <div id="triangle"></div>
            <h1>Usuario</h1>
 
                <form method="POST" action="../ImagensServlet" enctype="multipart/form-data">           
                <div id="usuario"> 
                    <input type="text" name="idUsuario" value="<%= usuarioImagem.getIdusuario() %>" hidden="" />
                     <img id="uploadPreview1" src="<%= usuarioImagem.getImagem()%>"  />
                     <input id="uploadImage1" type="file" name="arquivo" onchange="PreviewImage(1);"  />                  
                     <input type="submit" value="Salvar" />   
                </div>
            </form>   
            <div> <a  href="#" onclick="closeWin();"><h2>Sair</h2></a>  </div>            
        </div>  

        <script type="text/javascript">
            function PreviewImage(no) {
                var oFReader = new FileReader();
                oFReader.readAsDataURL(document.getElementById("uploadImage"+no).files[0]);

                oFReader.onload = function (oFREvent) {
                    document.getElementById("uploadPreview"+no).src = oFREvent.target.result;
                };
            }
        </script>

    </body>
</html>
