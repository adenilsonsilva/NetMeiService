/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.netmei.servlet;

import br.com.netmei.bean.Empresa;
import br.com.netmei.bean.Usuario;
import br.com.netmei.dao.GenericDao;
import br.com.netmei.dao.UsuarioDao;
import br.com.netmei.util.Encripta;
import br.com.netmei.util.EnviaEmail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
@WebServlet(name = "RegistrarServlet", urlPatterns = {"/RegistrarServlet"})
public class RegistrarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            EnviaEmail enviaEmail = new EnviaEmail();
            
            //Empresa
            Empresa empresa = new Empresa();            
            empresa.setRazaosocial(request.getParameter("razaosocial"));
            empresa.setTelefone(request.getParameter("telefone"));
            empresa.setCep(request.getParameter("cep"));
            empresa.setEndereco(request.getParameter("endereco"));
            
            if (request.getParameter("numero").isEmpty()){
                empresa.setNumero(0);
            }else{                
                empresa.setNumero(Integer.parseInt(request.getParameter("numero")));
            }
            empresa.setComplemento("complemento");
            empresa.setCidade(request.getParameter("cidade"));
            empresa.setBairro(request.getParameter("bairro"));
            empresa.setEstado(request.getParameter("estado"));
            
            //Usuário                      
            Usuario usuario = new Usuario();   
            usuario.setEmail(request.getParameter("email"));
            usuario.setNome(request.getParameter("nome"));
            usuario.setSenha( Encripta.Criptografar(request.getParameter("senha")));
            usuario.setNome(request.getParameter("nome"));
            
            //Dao
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuarioEmail = usuarioDao.ListarFiltroEmail(usuario.getEmail());
   
            if (usuarioEmail != null){
                request.setAttribute("mensagem", "Email já cadastrado! ");
                request.setAttribute("mensagem2", "<a href=\"Registrar.jsp\">Registrar</a>");
                request.setAttribute("mensagem3", "<a href=\"Login.jsp\">Acessar BelAdm</a>");
                request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
                return;
             }
           
            GenericDao genericDao = new GenericDao();
            Empresa objeto = (Empresa) genericDao.salvarId(empresa);
            
            //Adiciona o idempresa antes de salvar
            usuario.setIdempresa(objeto.getIdempresa());            
            Usuario usuarioSalvo = (Usuario) genericDao.salvarId(usuario);        
            
            
           //Envia Email            
            request.setAttribute("empresa", empresa);
            request.setAttribute("usuario", usuario);
            enviaEmail.setAssunto("BelAdm Cadastro Realizado com sucesso!");
            
            enviaEmail.setDestinatario(usuario.getEmail());
            String mensagem = "Usuario Cadastrado com sucesso! <br>" +
                              "Acesse o link abaixo e começe a usar agora mesmo o BelAdm: <br>" +
                              "http://localhost:8084/BelAdm/ConfirmaAcesso.jsp?cod=" + (usuarioSalvo.getIdusuario() * 853);
            
            enviaEmail.setMensagem(mensagem);
            enviaEmail.EnviarEmail();
            
            
            
            request.getRequestDispatcher("RegistroEfetuado.jsp").forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
