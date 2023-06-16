/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netmei.dao;


import br.com.netmei.bean.Usuario;
import br.com.netmei.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author Adenilson
 */
public class UsuarioDao {
    public Usuario getObjeto(Integer id) {
         Usuario usuario = null;
        try{    
            Session session = HibernateUtil.getSessionFactory().openSession();
             usuario =  (Usuario) session.get(Usuario.class, id);
            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }   
        return  usuario;
    }
    
    public List<Object> Listar() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List ListaUsuario = session.createQuery("From Usuario").list();
        session.beginTransaction().commit();
        return ListaUsuario;
    }

    public Usuario ListarFiltroEmail(String email) {
        List listaUsuario = new ArrayList();
        Usuario usuario = null;
        try{ 
       
           Session session = HibernateUtil.getSessionFactory().getCurrentSession();
           Transaction transaction= session.getTransaction();
           transaction.begin();
           Query lista = session.createQuery("From Usuario where email = :email ");
           lista.setString("email", email);     
           listaUsuario = lista.list();      
           transaction.commit();
           if (listaUsuario.size() > 0){
               usuario = (Usuario) listaUsuario.get(0); 
           }
           
        }catch (HibernateException e){ 
          System.out.println(e.getMessage());
        
        }
        
        return usuario;   
    }
    
     public Usuario ListarFiltroLogin(String email, String senha) {
        List listaUsuario = new ArrayList();
        Usuario usuario = null;
         try{        
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction transaction= session.getTransaction();
                transaction.begin();
                Query lista = session.createQuery("From Usuario where email = :email  and senha = :senha ");
                lista.setString("email", email);     
                lista.setString("senha", senha);     
                listaUsuario = lista.list();
                transaction.commit();
                if (listaUsuario.size() > 0){
                    usuario = (Usuario) listaUsuario.get(0);
                }
         }catch (Exception e){ 
             System.out.println(e.getMessage());
         }  
         return usuario;
    }
         
 }
