/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.tpi135.academica.casos.sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.casos.TipoRequisito;

/**
 *
 * @author omar
 */
@Stateless
public class TipoRequisitoFacade extends AbstractFacade<TipoRequisito> implements TipoRequisitoFacadeLocal {

    @PersistenceContext(unitName = "AcadCasosApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoRequisitoFacade() {
        super(TipoRequisito.class);
    }
    
}
