/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import EntityBeans.Sua;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hv
 */
@Stateless
public class SuaSB implements SuaSBLocal {

    @PersistenceContext(unitName = "QLBanSuaEE-ejbPU")
    private EntityManager em;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Sua> DocSuaTheoLoai(String maLoai) {
        Query query = em.createQuery("select s from Sua s where s.maloaisua.maloaisua=:maloaisua");
        query.setParameter("maloaisua", maLoai);
        return query.getResultList();
    }

    @Override
    public List<Sua> DocSuaTheoHang(String maHang) {
        Query query = em.createQuery("select s from Sua s where s.mahangsua.mahangsua=:mahangsua");
        query.setParameter("mahangsua", maHang);
        return query.getResultList();
    }

    @Override
    public List<Sua> DocSuaTheoTen(String tenSua) {
        Query query = em.createQuery("select s from Sua s where s.tensua=:tensua");
        query.setParameter("tensua", "%"+tenSua+"%");
        return query.getResultList();
    }

    @Override
    public List<Sua> DocSuaTheoLoaiHangTen(String maLoai, String maHang, String tenSua) {
        Query query = em.createQuery("select s from Sua s where s.maloaisua.maloaisua=:maloaisua and s.mahangsua.mahangsua=:mahangsua and s.tensua like :tensua");
        query.setParameter("maloaisua", maLoai);
        query.setParameter("mahangsua", maHang);
        query.setParameter("tensua", "%"+tenSua+"%");
        return query.getResultList();
    }

    @Override
    public List<Sua> SuaBanChay(int top) {
        Query query = em.createQuery("select s, sum(ct.soluong) as tsl from Sua s inner join s.ctHoadonList ct group by s order by tsl desc");
        query.setFirstResult(0);
        query.setMaxResults(top);
        List<Object> lst = query.getResultList();
        List<Sua> dssbc = new ArrayList<>();
        for(Object ob:lst){
            Object[] m = (Object[])ob;
            Sua sua = (Sua)m[0];
            dssbc.add(sua);
        }
        return dssbc;
    }

    @Override
    public List<Sua> SuaTheoTrang(String maLoai, String maHang, int trang, int soDongMoiTrang) {
        int viTriDau = (trang-1)*soDongMoiTrang;
        Query query = null;
        if(maLoai!=null){
            query = em.createQuery("select s from Sua s where s.maloaisua.maloaisua=:maloaisua");
            query.setParameter("maloaisua",maLoai);
        }
        else if(maHang!=null){
            query = em.createQuery("select s from Sua s where s.mahangsua.mahangsua=:mahangsua");
            query.setParameter("mahangsua",maHang);
        }
        else{
            query = em.createQuery("select s from Sua s");
        }
        query.setFirstResult(viTriDau);
        query.setMaxResults(soDongMoiTrang);
        return query.getResultList();
    }
}
