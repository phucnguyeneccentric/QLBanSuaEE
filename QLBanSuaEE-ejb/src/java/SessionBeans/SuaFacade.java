/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Sua;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hv
 */
@Stateless
public class SuaFacade extends AbstractFacade<Sua> implements SuaFacadeLocal {
    @PersistenceContext(unitName = "QLBanSuaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuaFacade() {
        super(Sua.class);
    }
    
}
