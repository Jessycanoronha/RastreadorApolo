package com.apolo.webapp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author raybm
 */
/*@Embeddable
public class UsuarioRastreadorId implements Serializable {

  @ManyToOne(fetch = FetchType.LAZY)
  @Column(name="idrastreador")
  private Rastreador rastreador;

  @ManyToOne(fetch = FetchType.LAZY)
  @Column(name="id")
  private Usuario usuario;

    public Rastreador getRastreador() {
        return rastreador;
    }

    public void setRastreador(Rastreador rastreador) {
        this.rastreador = rastreador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.rastreador);
        hash = 41 * hash + Objects.hashCode(this.usuario);
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
        final UsuarioRastreadorId other = (UsuarioRastreadorId) obj;
        if (!Objects.equals(this.rastreador, other.rastreador)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioRastreadorId{" + "rastreador=" + rastreador + ", usuario=" + usuario + '}';
    }

  
    
}*/
