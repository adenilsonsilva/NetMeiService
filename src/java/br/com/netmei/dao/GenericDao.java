/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netmei.dao;

import br.com.netmei.interfaces.InterfaceGeneric;
import br.com.netmei.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Adenilson
 */
public class GenericDao implements InterfaceGeneric {

   @Override
    public Object getObjeto(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Object object = (Object) session.get(Object.class, id);
        return  object;
    }

    @Override
     public void salvar(Object objeto) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.save(objeto);
        transaction.commit();
    }

    @Override
    public void atualizar(Object Object) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.merge(Object);
        transaction.commit();
    }

    @Override
    public void deletar(Object Object) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction= session.getTransaction();
        transaction.begin();
        session.delete(Object);
        transaction.commit();
    }

    @Override
    public Object salvarId(Object objeto) {
        try{
            
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction= session.getTransaction();
            transaction.begin();
            session.save(objeto);
            transaction.commit();

            return objeto; 

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
          return objeto; 
    }
    
}
