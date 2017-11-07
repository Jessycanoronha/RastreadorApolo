package com.apolo.webapp.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="log")
public class Log implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="idtipolog")
    private TipoLog idtipolog;
    
    @Column(name="descricao")
    private String descricao;
    
    @ManyToOne 
    @JoinColumn(name="idusuario")
    private Usuario idusuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datalog", columnDefinition = "DATE")
    private Date dataLog;
    
    @Column(name="ip")
    private String ip;
    
    @Column(name="nomemaquina")
    private String nomemaquina;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoLog getIdTipoLog() {
        return idtipolog;
    }

    public void setIdTipoLog(TipoLog idTipoLog) {
        this.idtipolog = idTipoLog;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getIdUsuario() {
        return idusuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idusuario = idUsuario;
    }

    public Date getDataLog() {
        return dataLog;
    }

    public void setDataLog(Date dataLog) {
        this.dataLog = dataLog;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNomemaquina() {
        return nomemaquina;
    }

    public void setNomemaquina(String nomemaquina) {
        this.nomemaquina = nomemaquina;
    }
    
}
