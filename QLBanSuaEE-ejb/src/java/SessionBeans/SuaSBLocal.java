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
public interface SuaSBLocal {
    List<Sua> DocSuaTheoLoai(String maLoai);
    List<Sua> DocSuaTheoHang(String maHang);
    List<Sua> DocSuaTheoTen(String tenSua);
    List<Sua> DocSuaTheoLoaiHangTen(String maLoai,String maHang,String tenSua);
    List<Sua> SuaBanChay(int top);
    List<Sua> SuaTheoTrang(String maLoai, String maHang, int trang,int soDongMoiTrang);
}
