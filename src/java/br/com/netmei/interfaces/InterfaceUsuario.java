/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netmei.interfaces;

import br.com.netmei.bean.Usuario;
import java.util.List;

/**
 *
 * @author Adenilson
 */
public interface InterfaceUsuario {
    public Usuario getObjeto(long id);
    public void salvar(Object objeto);
    public void atualizar(Object Object);
    public void deletar(Object Object);
    public List<Object> Listar();
    public List<Object> ListarFiltro(String email);
    
}
    
