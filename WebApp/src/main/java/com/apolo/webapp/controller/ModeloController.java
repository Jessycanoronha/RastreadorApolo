package com.apolo.webapp.controller;

import com.apolo.webapp.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author raybm
 */
@ManagedBean(name = "ModeloController")
@ViewScoped
public class ModeloController implements Serializable{
    public void verificarSessao(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if(us == null){
                context.getExternalContext().redirect("./../permissao.xhtml");
            }
        } catch (Exception e) {
            //log para guardar registros
        }
    }
}
