/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apolo.webapp.ejb;

import com.apolo.webapp.model.TipoLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author raybm
 */
@Local
public interface TipoLogFacadeLocal {

    void create(TipoLog tipoLog);

    void edit(TipoLog tipoLog);

    void remove(TipoLog tipoLog);

    TipoLog find(Object id);

    List<TipoLog> findAll();

    List<TipoLog> findRange(int[] range);

    int count();
    
}
