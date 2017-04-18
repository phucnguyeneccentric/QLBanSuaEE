/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.CtHoadon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hv
 */
@Local
public interface CtHoadonFacadeLocal {

    void create(CtHoadon ctHoadon);

    void edit(CtHoadon ctHoadon);

    void remove(CtHoadon ctHoadon);

    CtHoadon find(Object id);

    List<CtHoadon> findAll();

    List<CtHoadon> findRange(int[] range);

    int count();
    
}
