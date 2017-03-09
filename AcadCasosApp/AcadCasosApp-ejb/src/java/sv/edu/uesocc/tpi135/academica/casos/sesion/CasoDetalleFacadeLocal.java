/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135.academica.casos.sesion;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.casos.CasoDetalle;

/**
 *
 * @author omar
 */
@Local
public interface CasoDetalleFacadeLocal {

    void create(CasoDetalle casoDetalle);

    void edit(CasoDetalle casoDetalle);

    void remove(CasoDetalle casoDetalle);

    CasoDetalle find(Object id);

    List<CasoDetalle> findAll();

    List<CasoDetalle> findRange(int[] range);

    int count();
    
}
