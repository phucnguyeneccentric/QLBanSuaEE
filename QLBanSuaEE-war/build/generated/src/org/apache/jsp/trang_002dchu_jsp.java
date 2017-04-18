package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class trang_002dchu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Views/dau-trang.jsp");
    _jspx_dependants.add("/Views/cuoi-trang.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Quản lý bán sữa</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/reset.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/style.css\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./css/layout.css\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"main\">\n");
      out.write("            <img src=\"./images/Baner.jpg\" width=\"960\" height=\"80\"/>\n");
      out.write("        </div>");
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "DanhSachSuaServlet", out, false);
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"main cuoi-trang\">\n");
      out.write("            <p>@2007-2016 Siêu thị sữa Happy Milk</p>\n");
      out.write("            <p>Địa chỉ: Số 1bis đường Nguyễn Du Quận 1 TP.HCM - Điện thoại: (08) 8741528</p>\n");
      out.write("            <p>happy_milk@milk.com.vn</p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
