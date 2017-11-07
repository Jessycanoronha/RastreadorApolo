/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apolo.webapp.ejb;

import com.apolo.webapp.model.Usuario;
import com.apolo.webapp.util.OpcoesLog;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "RastreadorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public boolean existeUsuario(Usuario u){
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "From Usuario u WHERE u.email = ?1";  
            Query query = em.createQuery(consulta);
            query.setParameter(1, u.getEmail());
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        } catch (Exception e) {
              throw e;
        }
        if(usuario == null)
            return false;
        else
            return true;
    }
    
    @Override
    public Usuario iniciarSessao(Usuario us){
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "From Usuario u WHERE u.email = ?1 and u.senha = ?2";  
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getEmail());
            query.setParameter(2, us.getSenha());

            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
    
}
