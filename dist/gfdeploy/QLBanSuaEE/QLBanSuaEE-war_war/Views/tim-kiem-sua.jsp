<%-- 
    Document   : tim-kiem-sua
    Created on : Apr 16, 2017, 3:29:29 PM
    Author     : NHQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page4" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
    <form name="frmTimKiem" action="trang-tim-kiem-sua.jsp" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>TÌM KIẾM THÔNG TIN SỮA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Loại sữa: 
                        <select name="cboLoaiSua">
                            <c:forEach items="${dsls}" var="ls">
                                <option value="${ls.maloaisua}">${ls.tenloai}</option>
                            </c:forEach>
                        </select>
                        Hãng sữa:
                        <select name="cboHangSua">
                            <c:forEach items="${dshs}" var="hs">
                                <option value="${hs.mahangsua}">${hs.tenhangsua}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tên sữa: <input type="text" name="txtTenSuaTim" value="" size="30"/>
                        <input type="submit" value="Tìm kiếm" name="btnTimKiem"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <c:if test="${sosp>0}">
        <p><b>Có ${sosp} sản phẩm được tìm thấy</b></p>
        <table border="0">
            <c:forEach items="${dsstt}" var="stt">
            <thead>
                <tr>
                    <th colspan="2" class="tieu-de-sua">${stt.tensua}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><img src="./images/${stt.hinh}"></td>
                    <td>
                        <p><b>Thành phần dinh dưỡng:</b><br>${stt.TPDinhDuong}</p>
                        <p><b>Lợi ích:</b><br>${stt.loiich}</p>
                        <p>Trọng lượng: ${stt.trongluong}gr - Đơn giá: ${stt.dongia}đ</p>
                    </td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </c:if>
    </div>
</div>