package com.apolo.webapp.model;

import com.apolo.webapp.ejb.SQLInjectionSafe;
import com.apolo.webapp.util.Criptografia;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author raybm
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
     
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id", nullable = false)
    private Pessoa id;
    
    @Column(name="email", unique=true, nullable=false)
    private @SQLInjectionSafe String email;
    
    @Column(name="senha", nullable=false)
    private @SQLInjectionSafe String senha;
    
    @Column(name="tipo", nullable=false)
    private String tipo;
    
    @OneToMany(mappedBy = "id.usuario")
    private Collection<UsuarioRastreador> usuarioRastreadorList;
    
    public Pessoa getId() {
        return id;
    }

    public void setId(Pessoa id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = Criptografia.criptografarSHA1(senha).toString();
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<UsuarioRastreador> getRastreadores() {
        return usuarioRastreadorList;
    }

    public void setRastreadores(Collection<UsuarioRastreador> usuarioRastreadorList) {
        this.usuarioRastreadorList = usuarioRastreadorList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;

        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + '}';
    }
    
}
