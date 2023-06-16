/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netmei.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adenilson
 */
public class Conversao {
    
      public static Date Converter(String Data){
        DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");  
        Date data = null ;  
        try {
            data = new java.sql.Date(forma.parse(Data).getDate() );
        } catch (ParseException ex) {
            Logger.getLogger(Conversao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
        
    }
    
}
