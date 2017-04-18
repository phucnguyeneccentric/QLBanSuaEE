/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.LoaiSua;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hv
 */
@Local
public interface LoaiSuaFacadeLocal {

    void create(LoaiSua loaiSua);

    void edit(LoaiSua loaiSua);

    void remove(LoaiSua loaiSua);

    LoaiSua find(Object id);

    List<LoaiSua> findAll();

    List<LoaiSua> findRange(int[] range);

    int count();
    
}
