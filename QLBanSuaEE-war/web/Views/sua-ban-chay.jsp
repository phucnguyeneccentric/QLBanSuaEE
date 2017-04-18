<%-- 
    Document   : sua-ban-chay
    Created on : Apr 16, 2017, 11:35:23 AM
    Author     : NHQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page3" class="main">
    <div class="col1">
        <p>Danh sách sữa bán chạy</p>
        <ul>
            <c:forEach items="${dssbc}" var="sbc">
            <li><a href="trang-sua-ban-chay.jsp?maSua=${sbc.masua}">${sbc.tensua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>
        <table>
            <tr>
                <td colspan="2" class="tieu-de-sua">${sua.tensua}</td>
            </tr>
            <tr>
                <td><img src="./images/${sua.hinh}"></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${sua.TPDinhDuong}</p>
                    <p><b><i>Lợi ích:</i></b><br>${sua.loiich}</p>
                    <p><b><i>Trọng lượng:</i></b> ${sua.trongluong} gr - <b><i>Đơn giá:</i></b> ${sua.dongia} đ</p>
                </td>
            </tr>
        </table>
    </div>
</div>