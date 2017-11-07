package com.apolo.webapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author raybm
 */
@Entity
@Table(name="RastreadorHistorico")
public class RastreadorHistorico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataHora", columnDefinition = "DATE")
    private Date dataHora;
    
    @ManyToOne 
    @JoinColumn(name="idRastreador")
    private Rastreador idRastreador;
       
    @Column(name = "tensao")
    private Double tensao;
    
    @Column(name = "corrente")
    private Double corrente;
    
    @Column(name = "posicao")
    private Integer posicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Rastreador getIdRastreador() {
        return idRastreador;
    }

    public void setIdRastreador(Rastreador idRastreador) {
        this.idRastreador = idRastreador;
    }

    public Double getTensao() {
        return tensao;
    }

    public void setTensao(Double tensao) {
        this.tensao = tensao;
    }

    public Double getCorrente() {
        return corrente;
    }

    public void setCorrente(Double corrente) {
        this.corrente = corrente;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final RastreadorHistorico other = (RastreadorHistorico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RastreadorHistorico{" + "id=" + id + ", dataHora=" + dataHora + ", idRastreador=" + idRastreador + ", tensao=" + tensao + ", corrente=" + corrente + ", posicao=" + posicao + '}';
    }
    
    
    
}
