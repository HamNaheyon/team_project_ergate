/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.66
 * Generated at: 2021-06-24 12:30:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fre_005fsignUp_005foption_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>프리랜서 회원(선택)</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("        integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            min-height: 100vh;\r\n");
      out.write("\r\n");
      out.write("            background-color: rgb(166, 206, 231);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .input-form {\r\n");
      out.write("            max-width: 680px;\r\n");
      out.write("\r\n");
      out.write("            margin-top: 80px;\r\n");
      out.write("            padding: 32px;\r\n");
      out.write("\r\n");
      out.write("            background: #fff;\r\n");
      out.write("            -webkit-border-radius: 10px;\r\n");
      out.write("            -moz-border-radius: 10px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);\r\n");
      out.write("            -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);\r\n");
      out.write("            box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)\r\n");
      out.write("        }\r\n");
      out.write("        .btn {\r\n");
      out.write("            background-color: #e1e1e1;\r\n");
      out.write("            color: black;\r\n");
      out.write("            border-radius: 3px;\r\n");
      out.write("            border: 2px solid rgb(107, 140, 172);\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .btn:hover {\r\n");
      out.write("            background-color: #e1e1e1;\r\n");
      out.write("            border: 2px solid rgb(107, 140, 172);\r\n");
      out.write("            color: black;\r\n");
      out.write("            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);\r\n");
      out.write("        }\r\n");
      out.write("        input[type=\"number\"]::-webkit-outer-spin-button, input[type=\"number\"]::-webkit-inner-spin-button\r\n");
      out.write("		{\r\n");
      out.write("		-webkit-appearance: none;\r\n");
      out.write("		margin: 0;\r\n");
      out.write("	}\r\n");
      out.write("    .col-md-3{\r\n");
      out.write("        float: left; \r\n");
      out.write("        width: 50%;\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"input-form-backgroud row\">\r\n");
      out.write("            <div class=\"input-form col-md-12 mx-auto\">\r\n");
      out.write("                <h4 class=\"mb-3\">회원가입(선택)</h4>\r\n");
      out.write("                <br> <hr>\r\n");
      out.write("                <form class=\"validation-form\" method=\"POST\" action=\"fre_signUp\" novalidate>\r\n");
      out.write("                    \r\n");
      out.write("                    <!-- 연락 가능 시간 1 -->\r\n");
      out.write("                    <div class=\"row mb-3 form-row\">\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                            <label for=\"time\">연락 가능 시간</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                            <input type=\"time\" class=\"form-control\" id=\"time1\" name=\"time1\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ~\r\n");
      out.write("                        <div class=\"col-md-3\"> \r\n");
      out.write("                            <input type=\"time\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <!-- 희망 급여 -->\r\n");
      out.write("                    <div class=\"row mb-3 form-row\">\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                            <label for=\"salary\">희망 급여</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- 희망 급여 1 -->\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                            <input type=\"number\" class=\"form-control salary\" id=\"salary1\" name=\"phone\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ~\r\n");
      out.write("                        <!-- 희망급여 2 -->\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                            <input type=\"number\" class=\"form-control salary\" id=\"salary2\" name=\"phone\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("					<div class=\"row mb-3 form-row\">\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<label for=\"feild\">분야</label>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- 분야 -->\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<select class=\"custom-select\" id=\"feild\" name=\"feild\"required>\r\n");
      out.write("								<option>웹개발</option>\r\n");
      out.write("								<option>앱개발</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</div>\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("							<label for=\"work\">근무 형태</label>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- 근무 형태 -->\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<select class=\"custom-select\" id=\"work\" name=\"work\" required>\r\n");
      out.write("								<option>자가</option>\r\n");
      out.write("								<option>회사</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("					<div class=\"row mb-3 form-row\">\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<label for=\"experience\">프리랜서 경험</label>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- 분야 -->\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<select class=\"custom-select\" id=\"experience\" name=\"experience\" required>\r\n");
      out.write("								<option>있습니다</option>\r\n");
      out.write("								<option>없습니다</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</div>\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("							<label for=\"skil\">스킬</label>\r\n");
      out.write("						</div>\r\n");
      out.write("						<!-- 근무 형태 -->\r\n");
      out.write("						<div class=\"col-md-3\">\r\n");
      out.write("							<select class=\"custom-select\" id=\"skil\" name=\"skil\" required>\r\n");
      out.write("								<option>C</option>\r\n");
      out.write("								<option>Python</option>\r\n");
      out.write("								<option>Java</option>\r\n");
      out.write("								<option>C++</option>\r\n");
      out.write("								<option>C#</option>\r\n");
      out.write("								<option>Visual Basic</option>\r\n");
      out.write("								<option>JavaScript</option>\r\n");
      out.write("								<option>PHP</option>\r\n");
      out.write("								<option>R</option>\r\n");
      out.write("								<option>SQL</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row mb-3 form-row\">\r\n");
      out.write("                        <div class=\"col-md-3\">\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <label for=\"gender\">성별</label> <br> <br>\r\n");
      out.write("                                <input type=\"radio\" name=\"gender\" id=\"gender\" value=\"M\"> 남\r\n");
      out.write("                                <input type=\"radio\" name=\"gender\" id=\"gender\" value=\"F\"> 여\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary float-left\" data-toggle=\"button\" aria-pressed=\"false\"\r\n");
      out.write("                    onclick=\"location.href='fre_signUp_Required'\">\r\n");
      out.write("                        	이전으로\r\n");
      out.write("                      </button>\r\n");
      out.write("                      <br> <br>  <hr>\r\n");
      out.write("                    <div class=\"mb-4\"></div>\r\n");
      out.write("                    <button class=\"btn btn-primary btn-lg btn-block\" type=\"submit\">가입하기</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
