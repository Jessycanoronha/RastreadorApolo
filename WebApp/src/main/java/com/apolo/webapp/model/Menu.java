package com.apolo.webapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author raybm
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable{
    @Id
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "tipoUsuario")
    private String tipoUsuario;
    
    @ManyToOne
    @JoinColumn(name = "id_submenu", nullable = false)
    private Menu subMenu;
    
    @Column(name = "estado")
    private Boolean estado = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }   

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Menu subMenu) {
        this.subMenu = subMenu;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
