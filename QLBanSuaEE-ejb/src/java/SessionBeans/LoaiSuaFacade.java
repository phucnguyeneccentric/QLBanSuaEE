/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.LoaiSua;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hv
 */
@Stateless
public class LoaiSuaFacade extends AbstractFacade<LoaiSua> implements LoaiSuaFacadeLocal {
    @PersistenceContext(unitName = "QLBanSuaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoaiSuaFacade() {
        super(LoaiSua.class);
    }
    
}
