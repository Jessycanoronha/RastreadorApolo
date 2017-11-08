package com.apolo.webapp.controller;

import com.apolo.webapp.ejb.UsuarioFacadeLocal;
import com.apolo.webapp.model.Usuario;
import com.apolo.webapp.util.Mensagens;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author raybm
 */
@ManagedBean(name = "IndexController")
@ViewScoped
public class IndexController implements Serializable{
    @EJB
    private UsuarioFacadeLocal EJBUsuario;
    
    @Inject
    private Usuario usuario; 
    
    @PostConstruct
    public void init(){
       // usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSessao(){
        Usuario us;
        String redirecionar = null;
        try {
            us = EJBUsuario.iniciarSessao(usuario);
            if(us != null){
                // Armazenar na sessão de JSF 
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redirecionar = "/restrito/principal?faces-redirect=true";
            }
            else
            {
               Mensagens.exibirMensagem("Usuário e/ou Senha Incorretos", true);    
            }
        } catch (Exception e) {
          Mensagens.exibirMensagem("Erro ao Registrar Usuário", true);    
        }
        return redirecionar;
    }
    
}
