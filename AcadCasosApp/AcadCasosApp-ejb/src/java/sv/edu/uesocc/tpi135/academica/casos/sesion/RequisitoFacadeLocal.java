/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135.academica.casos.sesion;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.casos.Requisito;

/**
 *
 * @author omar
 */
@Local
public interface RequisitoFacadeLocal {

    void create(Requisito requisito);

    void edit(Requisito requisito);

    void remove(Requisito requisito);

    Requisito find(Object id);

    List<Requisito> findAll();

    List<Requisito> findRange(int[] range);

    int count();
    
}
