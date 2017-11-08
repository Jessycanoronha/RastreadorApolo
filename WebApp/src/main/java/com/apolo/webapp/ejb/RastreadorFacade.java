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
    
    public Rastreador findChave(String chave){
        String consulta;
        Rastreador r = null;
        try {
            consulta = "From Rastreador r WHERE r.chave = ?1";  
            Query query = em.createQuery(consulta);
            query.setParameter(1, chave);
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
