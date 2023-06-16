<%-- 
    Document   : Registrar
    Created on : 13/10/2014, 21:30:03
    Author     : Cliente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BelAdm</title>
        <link href="css/registrar.css" rel="stylesheet">    
    </head>
    <body>
        <div id="registrar">
            <div id="triangle"></div>
            <h1>Usuario</h1>
            <form action="RegistrarServlet" method="POST">
                <div id="usuario">  
                    <input type="text" placeholder="Nome" name="mome" required="required" title=""/>
                    <input type="email" placeholder="Email" name="email" required="required" title=""/>
                    <input type="password" placeholder="Senha" name="senha" required="required" title=""/>
                </div>
                <div id="empresa">              
                    <h2>Empresa</h2>
                    <input type="text" placeholder="Empresa" name="razaosocial" required="required"/>
                    <input type="text" placeholder="Telefone" id="telefone" name="telefone"  pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4}"  title="Telefone (XXX)XXXX-XXXX"/>
                    <input type="text" placeholder="CEP"  name="cep"  pattern="[0-9]{5}(\-[0-9]{3})?" title="CEP"/>
                    <input type="text" placeholder="Endereço" name="endereco" title="Endereço"/>
                    <input type="text" placeholder="Número" name="numero" title="Número" pattern="[0-9]{5}"/>
                    <input type="text" placeholder="Bairro" name="bairro" title="Bairro"/>

                    <input type="text" placeholder="Cidade" name="cidade" title="Cidade"/>
                    <select name="estado" title="Estado">
                        <option value=''>Estado </option>
                        <option value='AC'>Acre</option>
                        <option  value='AL'>Alagoas</option>
                        <option value='AP'>Amapá</option>
                        <option value='AM'>Amazonas</option>
                        <option value='BA'>Bahia</option>
                        <option value='CE'>Ceará</option>
                        <option value='DF'>Distrito Federal</option>
                        <option value='ES'>Espírito Santo</option>
                        <option value='GO'>Goiás</option>
                        <option value='MA'>Maranhão</option>
                        <option value='MT'>Mato Grosso</option>
                        <option value='MS'>Mato Grosso do Sul</option>
                        <option value='MG'>Minas Gerais</option>
                        <option value='PA'>Pará</option>
                        <option value='PB'>Paraíba</option>
                        <option value='PR'>Paraná</option>
                        <option value='PE'>Pernambuco</option>
                        <option value='PI'>Piauí</option>
                        <option value='RJ'>Rio de Janeiro</option>
                        <option value='RN'>Rio Grande do Norte</option>
                        <option value='RS'>Rio Grande do Sul</option>
                        <option value='RO'>Rondônia</option>
                        <option value='RR'>Roraima</option>
                        <option value='SC'>Santa Catarina</option>
                        <option value='SP'>São Paulo</option>
                        <option value='SE'>Sergipe</option>
                        <option value='TO'>Tocantins</option>
                    </select>
                    <input type="submit" value="Registrar" />   
                </div>
            </form>     
        </div>
    </body> 
</html>
