/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.HangSua;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hv
 */
@Stateless
public class HangSuaFacade extends AbstractFacade<HangSua> implements HangSuaFacadeLocal {
    @PersistenceContext(unitName = "QLBanSuaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HangSuaFacade() {
        super(HangSua.class);
    }
    
}
