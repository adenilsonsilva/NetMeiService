/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.netmei.servlet;

import br.com.netmei.bean.Usuario;
import br.com.netmei.dao.GenericDao;
import br.com.netmei.dao.UsuarioDao;
import br.com.netmei.util.Encripta;
import br.com.netmei.util.EnviaEmail;
import br.com.netmei.util.GeradorSenha;
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
@WebServlet(name = "RecuperarSenhaServlet", urlPatterns = {"/RecuperarSenhaServlet"})
public class RecuperarSenhaServlet extends HttpServlet {

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
            String email = request.getParameter("email");
            
            EnviaEmail enviaEmail = new EnviaEmail();
            GeradorSenha geradorSenha = new GeradorSenha();
            String novaSenha, novaSenhaCript;
            
            //Dao
            UsuarioDao usuarioDao = new UsuarioDao();
            GenericDao genericDao = new GenericDao();
            Usuario usuarioEmail = usuarioDao.ListarFiltroEmail(email);
            
            
            if (usuarioEmail == null){
                request.setAttribute("mensagem", "Usuario não encontarado! ");
                request.setAttribute("mensagem2", "<a href=\"Registrar.jsp\">Registrar</a>");
                request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
                return;
             }
            
            Usuario usuario = usuarioDao.getObjeto(usuarioEmail.getIdusuario());
            novaSenha = geradorSenha.NovaSenha();
            novaSenhaCript = Encripta.Criptografar(novaSenha);
            usuario.setSenha(novaSenhaCript);
                    
            genericDao.atualizar(usuario);
            
            enviaEmail.setDestinatario(usuario.getEmail());
            enviaEmail.setAssunto("BelAdm - Novo Acesso");
 
            String mensagem = "Sua nova senha de acesso é: " + novaSenha + "<br>" +
                              "Acesse o link abaixo e começe a usar agora mesmo o BelAdm: <br>" +
                              "http://localhost:8084/BelAdm/Login.jsp";
            enviaEmail.setMensagem(mensagem);
           
            enviaEmail.EnviarEmail();
            request.setAttribute("mensagem", "Uma nova senha foi enviada para o seu Email! ");
            request.setAttribute("mensagem2", "<a href=\"Login.jsp\">Acessar BelAdm</a>");
            request.getRequestDispatcher("Mensagem.jsp").forward(request, response);

            
            
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
