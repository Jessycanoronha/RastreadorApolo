package com.apolo.webapp.controller;

import com.apolo.webapp.ejb.MenuFacadeLocal;
import com.apolo.webapp.model.Menu;
import com.apolo.webapp.model.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author raybm
 */
@ManagedBean(name = "MenuController")
@SessionScoped
public class MenuController implements Serializable{
    
    @EJB
    private MenuFacadeLocal EJBMenu;
    private List<Menu> lista;
    private MenuModel model;
    
    @PostConstruct
    public void init(){
        this.listarMenus();
        model = new DefaultMenuModel();
        this.definirPermissoes();
    }
    
    public void listarMenus(){
        try {
            lista = EJBMenu.findAll();
        } catch (Exception e) {
            //mensagem erro
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    public void definirPermissoes(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        for(Menu m : lista){
         if(m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getTipo())){
             DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNome());
             for(Menu i : lista){
                 Menu subMenu = i.getSubMenu();
                 if (subMenu != null) {
                     if(subMenu.getId() == m.getId()){
                         DefaultMenuItem item = new DefaultMenuItem(i.getNome());
                         item.setUrl(i.getUrl());
                         firstSubMenu.addElement(item);
                     }
                 }
             }
             model.addElement(firstSubMenu);
         }
         else
         {
             if(m.getSubMenu() == null && m.getTipoUsuario().equals(us.getTipo())){
                DefaultMenuItem item = new DefaultMenuItem(m.getNome());
                item.setUrl(m.getUrl());
                model.addElement(item);
             }   
         }
        }
    }
    
    public void fecharSessao(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public Usuario getUsuarioLogado(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us;
    }
    
    public String getSaudacao(){
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        String saudacao;
        if(hora >= 0 && hora < 12)
            saudacao = "Bom Dia";
        else
        if(hora >= 12 && hora < 18)
            saudacao = "Boa Tarde";
        else
            saudacao = "Boa Noite";
        
        return saudacao;
    }
}
