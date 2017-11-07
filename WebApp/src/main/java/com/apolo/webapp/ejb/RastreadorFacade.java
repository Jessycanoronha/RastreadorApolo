/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apolo.webapp.ejb;

import com.apolo.webapp.model.Rastreador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author raybm
 */
@Stateless
public class RastreadorFacade extends AbstractFacade<Rastreador> implements RastreadorFacadeLocal {

    @PersistenceContext(unitName = "RastreadorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RastreadorFacade() {
        super(Rastreador.class);
    }
    
    @Override
    public Rastreador findKey(String key){
        String consulta;
        Rastreador r = null;
        try {
            consulta = "From Rastreador r WHERE r.key = ?1";  
            Query query = em.createQuery(consulta);
            query.setParameter(1, key);
            List<Rastreador> lista = query.getResultList();
            if(!lista.isEmpty()){
                r = lista.get(0);
            }
        } catch (Exception e) {
              throw e;
        }
        return r;
    }
    
}
