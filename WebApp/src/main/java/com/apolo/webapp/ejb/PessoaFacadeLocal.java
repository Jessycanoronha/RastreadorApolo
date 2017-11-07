package com.apolo.webapp.ejb;

import com.apolo.webapp.model.Pessoa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author raybm
 */
@Local
public interface PessoaFacadeLocal {

    void create(Pessoa pessoa);

    void edit(Pessoa pessoa);

    void remove(Pessoa pessoa);

    Pessoa find(Object id);

    List<Pessoa> findAll();

    List<Pessoa> findRange(int[] range);

    int count();
        
}
