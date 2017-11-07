package com.apolo.webapp.controller;

import com.apolo.webapp.ejb.PessoaFacadeLocal;
import com.apolo.webapp.ejb.UsuarioFacadeLocal;
import com.apolo.webapp.model.Pessoa;
import com.apolo.webapp.model.Usuario;
import com.apolo.webapp.util.Mensagens;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author raybm
 */
@ManagedBean(name = "UsuarioController")
@ViewScoped
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @Inject
    private Usuario usuario;
    @Inject
    private Pessoa pessoa;
    
    @PostConstruct
    public void init(){
        //usuario = new Usuario();
        //pessoa = new Pessoa();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public void registrar(){
        try {
          this.usuario.setId(pessoa);
          if(usuarioEJB.existeUsuario(usuario))
          {
            Mensagens.exibirMensagem("Email já Cadastrado", true);
            return;
          }
          usuarioEJB.create(usuario);
          Mensagens.exibirMensagem("Usuário Registrado", false);
        } catch (Exception e) { 
          Mensagens.exibirMensagem("Erro ao Registrar Usuário", true);
        }
    }
            
    
}
