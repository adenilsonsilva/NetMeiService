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
import br.com.netmei.util.Global;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
            Usuario usuario = new Usuario();
            if (request.getParameter("isusuario")!=null){
                usuario.setIdusuario(Integer.parseInt(request.getParameter("isusuario")));
            }
            boolean ativo = (request.getParameter("ativo") == "ON");
            
            usuario.setNome(request.getParameter("nome"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(Encripta.Criptografar(request.getParameter("senha")));    
            usuario.setAtivo(ativo);
            usuario.setIdempresa(Global.idEmpresa);
            usuario.setDtalteracao(new Date(System.currentTimeMillis()));
            
                        //Dao
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuarioEmail = usuarioDao.ListarFiltroEmail(usuario.getEmail());
   
            if (usuarioEmail != null){
                request.setAttribute("mensagem", "Email já cadastrado! ");
                request.getRequestDispatcher("Mensagem.jsp").forward(request, response);
                return;
             }
            
            GenericDao genericDao = new GenericDao();
            genericDao.salvar(usuario); 
            
            response.sendRedirect("UsuarioLista.jsp");
            
            
            
            
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
