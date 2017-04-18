/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.HangSua;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hv
 */
@Local
public interface HangSuaFacadeLocal {

    void create(HangSua hangSua);

    void edit(HangSua hangSua);

    void remove(HangSua hangSua);

    HangSua find(Object id);

    List<HangSua> findAll();

    List<HangSua> findRange(int[] range);

    int count();
    
}
