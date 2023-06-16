
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/login.css" rel="stylesheet">
    </head>
    
    <body>
        <div class="materialContainer">
            
           <div id="box">
             <% Object erro;
                erro = request.getAttribute("erro");

                if (erro != null){
                    out.println("<H1>Usuário ou senha inválida!</H1>");
                }
        
            %>                     
            
            
            <form class="form-control" action="LoginServlet" method="POST">
                <hgroup>
                    <h1>DNSLeads</h1>
                    <h3></h3>
                </hgroup>    
            
                <div class="group">
                    <input type="email" name="email"/> <span class="highlight"></span><span class="bar"></span>
                    <label>Email</label>
                </div> 
                
              <div class="group">
                <input type="password" name="senha"/></span><span class="bar"></span>
                  <label>Senha</label>
              </div>                
                
              <input type="submit" class="button buttonBlue" value="Acessar" />              
              
              <div class="button buttonred"><a href="Registrar.jsp"><h2>Registrar</h2></a>  </div>
              <div class="button buttongreen"><a href="RecuperarSenha.jsp"><h1>Recuperar Senha</h1></a> </div>
            </form>           
            
        </div>
        </div>        
            
            
            
     
        
        
    </body>
</html>
