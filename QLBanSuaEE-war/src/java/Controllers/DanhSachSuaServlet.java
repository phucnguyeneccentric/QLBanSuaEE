/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EntityBeans.HangSua;
import EntityBeans.LoaiSua;
import EntityBeans.Sua;
import SessionBeans.HangSuaFacadeLocal;
import SessionBeans.LoaiSuaFacadeLocal;
import SessionBeans.SuaFacadeLocal;
import SessionBeans.SuaSBLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hv
 */
@WebServlet(name = "DanhSachSuaServlet", urlPatterns = {"/DanhSachSuaServlet"})
public class DanhSachSuaServlet extends HttpServlet {
    @EJB
    private SuaFacadeLocal suaFacade;
    @EJB
    private SuaSBLocal suaSB;
    @EJB
    private HangSuaFacadeLocal hangSuaFacade;
    @EJB
    private LoaiSuaFacadeLocal loaiSuaFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String maLoai, maHang;
        List<Sua> dsSua = null;
        
        maLoai = request.getParameter("maLoai");
        maHang = request.getParameter("maHang");

        int tongSoDong=0,soDongMoiTrang=6,tongSoTrang,trang=1;

        if(maLoai!=null)
            dsSua = suaSB.DocSuaTheoLoai(maLoai);
        else if(maHang!=null)
            dsSua = suaSB.DocSuaTheoHang(maHang);
        else
            dsSua = suaFacade.findAll();
            
        tongSoDong=dsSua.size();
        if(request.getParameter("trang")!=null)
            trang = Integer.parseInt(request.getParameter("trang"));

        dsSua = suaSB.SuaTheoTrang(maLoai, maHang, trang, soDongMoiTrang);

        tongSoTrang=tongSoDong/soDongMoiTrang;
        tongSoTrang += (tongSoDong%soDongMoiTrang==0)?0:1;
        
        List<LoaiSua> dsls = loaiSuaFacade.findAll();
        List<HangSua> dshs = hangSuaFacade.findAll();
        
        request.setAttribute("dsls", dsls);
        request.setAttribute("dshs", dshs);
        request.setAttribute("dsSua", dsSua);
        request.setAttribute("tongSoTrang",tongSoTrang);
        request.getRequestDispatcher("Views/danh-sach-sua.jsp").include(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
