/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apolo.webapp.ejb;

import com.apolo.webapp.model.TipoLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author raybm
 */
@Stateless
public class TipoLogFacade extends AbstractFacade<TipoLog> implements TipoLogFacadeLocal {

    @PersistenceContext(unitName = "RastreadorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoLogFacade() {
        super(TipoLog.class);
    }
    
}
