<%@ page contentType="text/html;charset=utf8"%>
<HTML>
<BODY >
	<h1>Hello！我是胡人</h1>
	<%
	request.getRequestDispatcher("/servlet/GetStatusServlet").forward(request, response);
	%>
</BODY>
</HTML>