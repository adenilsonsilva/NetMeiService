package br.com.netmei.bean;
// Generated 20/10/2014 21:15:39 by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Usuario generated by hbm2java
 */

@Entity
public class Usuario  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int idusuario;
     private Integer idempresa;
     private String nome;
     private String email;
     private String senha;
     private Date dtalteracao;
     private Boolean ativo;
     private String imagem;

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param idusuario
     */
    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     *
     * @param idusuario
     * @param idempresa
     * @param nome
     * @param email
     * @param senha
     * @param dtalteracao
     * @param ativo
     * @param imagem
     */
    public Usuario(int idusuario, Integer idempresa, String nome, String email, String senha, Date dtalteracao, Boolean ativo, String imagem) {
       this.idusuario = idusuario;
       this.idempresa = idempresa;
       this.nome = nome;
       this.email = email;
       this.senha = senha;
       this.dtalteracao = dtalteracao;
       this.ativo = ativo;
       this.imagem = imagem;
    }
   
    /**
     *
     * @return
     */
    public int getIdusuario() {
        return this.idusuario;
    }
    
    /**
     *
     * @param idusuario
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     *
     * @return
     */
    public Integer getIdempresa() {
        return this.idempresa;
    }
    
    /**
     *
     * @param idempresa
     */
    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return this.senha;
    }
    
    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public Date getDtalteracao() {
        return this.dtalteracao;
    }
    
    /**
     *
     * @param dtalteracao
     */
    public void setDtalteracao(Date dtalteracao) {
        this.dtalteracao = dtalteracao;
    }

    /**
     *
     * @return
     */
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    /**
     *
     * @param ativo
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     *
     * @return
     */
    public String getImagem() {
        return this.imagem;
    }
    
    /**
     *
     * @param idimagem
     */
    public void setImagem(String idimagem) {
        this.imagem = idimagem;
    }




}

