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
import SessionBeans.SuaSBLocal;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "TimKiemSuaServlet", urlPatterns = {"/TimKiemSuaServlet"})
public class TimKiemSuaServlet extends HttpServlet {

    @EJB
    private HangSuaFacadeLocal hangSuaFacade;

    @EJB
    private LoaiSuaFacadeLocal loaiSuaFacade;

    @EJB
    private SuaSBLocal suaSB;

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

        String maHang, maLoai, tenSuaTim;
        List<Sua> dsstt = new ArrayList<>();
        
        if(request.getParameter("btnTimKiem")!=null){
            maHang = request.getParameter("cboHangSua");
            maLoai = request.getParameter("cboLoaiSua");
            tenSuaTim = request.getParameter("txtTenSuaTim");
            dsstt = suaSB.DocSuaTheoLoaiHangTen(maLoai, maHang, tenSuaTim);
        }
        List<LoaiSua> dsls = loaiSuaFacade.findAll();
        List<HangSua> dshs = hangSuaFacade.findAll();

        request.setAttribute("dsstt", dsstt);
        request.setAttribute("dsls", dsls);
        request.setAttribute("dshs", dshs);
        request.setAttribute("sosp", dsstt.size());
        request.getRequestDispatcher("Views/tim-kiem-sua.jsp").include(request, response);
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
