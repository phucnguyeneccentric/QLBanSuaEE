/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import EntityBeans.KhachHang;
import SessionBeans.KhachHangFacadeLocal;
import java.io.IOException;
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
@WebServlet(name = "ThemKhachHangServlet", urlPatterns = {"/ThemKhachHangServlet"})
public class ThemKhachHangServlet extends HttpServlet {

    @EJB
    private KhachHangFacadeLocal khachHangFacade;

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
        
        if(request.getParameter("btnThemMoi")!=null){
            String maKH, tenKH, diaChi, dienThoai, email;
            Boolean phai;
            
            maKH = request.getParameter("txtMaKH");
            tenKH = request.getParameter("txtTenKH");
            diaChi = request.getParameter("txtDiaChi");
            dienThoai = request.getParameter("txtDienThoai");
            email = request.getParameter("txtEmail");
            if(request.getParameter("rdbPhai").equals("nam"))
                phai=true;
            else
                phai = false;
            KhachHang khachHang = new KhachHang(maKH, tenKH, phai, diaChi, dienThoai, email);
            khachHangFacade.create(khachHang);
        }
        request.getRequestDispatcher("Views/them-khach-hang.jsp").include(request, response);
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
