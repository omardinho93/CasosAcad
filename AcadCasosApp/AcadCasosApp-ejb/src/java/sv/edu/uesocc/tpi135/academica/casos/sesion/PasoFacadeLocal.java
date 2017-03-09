/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135.academica.casos.sesion;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.casos.Paso;

/**
 *
 * @author omar
 */
@Local
public interface PasoFacadeLocal {

    void create(Paso paso);

    void edit(Paso paso);

    void remove(Paso paso);

    Paso find(Object id);

    List<Paso> findAll();

    List<Paso> findRange(int[] range);

    int count();
    
}
