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
 * @author NHQ
 */
@WebServlet(name = "ThemSuaMoiServlet", urlPatterns = {"/ThemSuaMoiServlet"})
public class ThemSuaMoiServlet extends HttpServlet {

    @EJB
    private SuaFacadeLocal suaFacade;

    @EJB
    private LoaiSuaFacadeLocal loaiSuaFacade;

    @EJB
    private HangSuaFacadeLocal hangSuaFacade;

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

        List<HangSua> dshs = hangSuaFacade.findAll();
        List<LoaiSua> dsls = loaiSuaFacade.findAll();
        Sua sua = null;

        String maSua, tenSua, maHang, maLoai, tpDinhDuong, loiIch, hinh;
        int trongLuong, donGia;

        if(request.getParameter("btnThemMoi")!=null){
            maSua = request.getParameter("txtMaSua");
            tenSua = request.getParameter("txtTenSua");
            maHang = request.getParameter("cboHangSua");
            maLoai = request.getParameter("cboLoaiSua");
            tpDinhDuong = request.getParameter("txtTPDinhDuong");
            loiIch = request.getParameter("txtLoiIch");
            hinh = request.getParameter("txtHinh");
            trongLuong = Integer.parseInt(request.getParameter("txtTrongLuong"));
            donGia = Integer.parseInt(request.getParameter("txtDonGia"));
            sua = new Sua(maSua, tenSua, trongLuong, donGia, tpDinhDuong, loiIch, hinh);
            sua.setMahangsua(hangSuaFacade.find(maHang));
            sua.setMaloaisua(loaiSuaFacade.find(maLoai));
            suaFacade.create(sua);
        }

        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        request.setAttribute("sua", sua);

        request.getRequestDispatcher("Views/them-sua-moi.jsp").include(request, response);
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
