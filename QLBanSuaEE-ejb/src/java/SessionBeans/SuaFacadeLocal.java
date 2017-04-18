/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Sua;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hv
 */
@Local
public interface SuaFacadeLocal {

    void create(Sua sua);

    void edit(Sua sua);

    void remove(Sua sua);

    Sua find(Object id);

    List<Sua> findAll();

    List<Sua> findRange(int[] range);

    int count();
    
}
