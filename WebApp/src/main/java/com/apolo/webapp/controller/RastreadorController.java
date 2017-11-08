package com.apolo.webapp.controller;

import com.apolo.webapp.ejb.RastreadorFacadeLocal;
import com.apolo.webapp.model.Rastreador;
import com.apolo.webapp.util.Criptografia;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author raybm
 */
@ManagedBean(name="RastreadoController")
@ViewScoped
public class RastreadorController implements Serializable{
    @EJB
    private RastreadorFacadeLocal rastreadorEJB;
    @Inject
    private Rastreador rastreador;

    public Rastreador getRastreador() {
        return rastreador;
    }

    public void setRastreador(Rastreador rastreador) {
        this.rastreador = rastreador;
    }
    
    public void registrar(){
        try {
            rastreador.setChave(Criptografia.getKey());
            rastreadorEJB.create(rastreador);
        } catch (Exception e) {
        }
    }
}
