/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.KhachHang;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hv
 */
@Stateless
public class KhachHangFacade extends AbstractFacade<KhachHang> implements KhachHangFacadeLocal {
    @PersistenceContext(unitName = "QLBanSuaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KhachHangFacade() {
        super(KhachHang.class);
    }
    
}
