/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netmei.interfaces;

/**
 *
 * @author Adenilson
 */
public interface InterfaceGeneric {
    public Object getObjeto(Integer id);
    public void salvar(Object objeto);
    public void atualizar(Object Object);
    public void deletar(Object Object);
    public Object salvarId(Object objeto);
   
    
}
