/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.netmei.servlet;

import br.com.netmei.bean.Usuario;
import br.com.netmei.dao.GenericDao;
import br.com.netmei.dao.UsuarioDao;
import br.com.netmei.util.GeradorSenha;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Cliente
 */
@WebServlet(name = "ImagensServlet", urlPatterns = {"/ImagensServlet"})
public class ImagensServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    private static final String SAVE_DIR = "uploadFiles";
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
            GeradorSenha geradorSenha = new GeradorSenha();
            GenericDao genericDao = new GenericDao();
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuarioImagem = usuarioDao.getObjeto(Integer.parseInt(request.getParameter("idusuario")));
            
            String appPath = request.getServletContext().getRealPath("");
     
            String savePath = appPath + File.separator + SAVE_DIR;

            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                String ext[] = fileName.split("\\.");   
                int i = ext.length;  
                String  nomeImagem = savePath + File.separator + geradorSenha.NovaSenha() + "." + ext[i-1];                 
                part.write(nomeImagem);
                usuarioImagem.setImagem(nomeImagem);
            }

            genericDao.salvar(usuarioImagem);
            getServletContext().getRequestDispatcher("/UsuarioImagem.jsp").forward(request, response);
           
          
           //genericDao.salvar(ImagemId);
            
        } catch (Exception ex) {
            Logger.getLogger(ImagensServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
