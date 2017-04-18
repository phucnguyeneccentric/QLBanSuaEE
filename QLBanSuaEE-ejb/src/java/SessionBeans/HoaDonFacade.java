/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.HoaDon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hv
 */
@Stateless
public class HoaDonFacade extends AbstractFacade<HoaDon> implements HoaDonFacadeLocal {
    @PersistenceContext(unitName = "QLBanSuaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HoaDonFacade() {
        super(HoaDon.class);
    }
    
}
