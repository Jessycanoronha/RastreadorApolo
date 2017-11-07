package com.apolo.webapp.ejb;

import com.apolo.webapp.model.Rastreador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author raybm
 */
@Local
public interface RastreadorFacadeLocal {

    void create(Rastreador rastreador);

    void edit(Rastreador rastreador);

    void remove(Rastreador rastreador);

    Rastreador find(Object id);

    List<Rastreador> findAll();

    List<Rastreador> findRange(int[] range);

    int count();
    
    Rastreador findKey(String key);   
}
