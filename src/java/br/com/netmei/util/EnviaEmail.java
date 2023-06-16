/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.netmei.util;


import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Cliente
 */
public class EnviaEmail {
    private String mensagem;
    private String assunto;
    private String destinatario;
  
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
  
       
    
    public int EnviarEmail(){
       
        String EmailLogin = "adenilson.denis.silva@gmail.com";
        String Senha      =  "cachorro";
        try{  

                Properties Propriedades = new Properties();            
                Propriedades.put("mail.smtp.host", "smtp.gmail.com");
                Propriedades.put("mail.smtp.starttls.enable","true");
                Propriedades.put("mail.smtp.user", EmailLogin);
                Propriedades.put("mail.smtp.socketfatory.port", "587");
                Propriedades.put("mail.smtp.auth","true");
                Propriedades.put("mail.smtp.port", "587");

                Authenticator Auth = new SMTPAuthenticator(EmailLogin, Senha);
                
                Session Sessao;
         
                Sessao = Session.getDefaultInstance(Propriedades, Auth); 
                               
                MimeMessage mensagem = new MimeMessage(Sessao);            
                mensagem.setFrom(new InternetAddress(this.getDestinatario()));

                Address Endereco = new InternetAddress(EmailLogin);            
                mensagem.addRecipient(Message.RecipientType.TO, Endereco);


                mensagem.setSubject(this.getAssunto());
                mensagem.setContent(this.getMensagem(), "text/html");


                Transport.send(mensagem);  
        } catch(MessagingException e){
            return 0;
        //    request.setAttribute("erro", e.getMessage());
          //  request.getRequestDispatcher("Erro.jsp").forward(request, response);
        } finally {            
            //out.close();
        }     
        return 1;
    }
    


    private class SMTPAuthenticator extends Authenticator{
        String EmailLogin;
        String Senha;

        public SMTPAuthenticator(String EmailLogin, String Senha){
            this.EmailLogin = EmailLogin;
            this.Senha = Senha;
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(EmailLogin, Senha);
        }


    }
}