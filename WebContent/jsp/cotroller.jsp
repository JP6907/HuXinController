<%@ page contentType="text/html;charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML>
<head>
  <meta charset="UTF-8">
  <title>控制终端</title>
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>

<%
	String led1 = (String)request.getParameter("led1");
	String led2 = (String)request.getParameter("led2");
	String source = (String)request.getParameter("source");
%>
<body>
  <h2>胡人智能家具控制</h2>
  <script >
  	GetStatus();
  </script>
<form action="<%=basePath %>servlet/ControllerServlet" id="ControllerForm" method="post">
<ul class='tg-list'>
  <li class='tg-list-item'>
    <h4>电源</h4>
    <input class='tgl tgl-skewed' id='cb3' name='source' value='source' type='checkbox' onclick="changeStatus()"
    	<%  if(source.equals("on"))
			{  
		%>
			checked="checked"
		<%  } 
		%>
    >
    <label class='tgl-btn' data-tg-off='OFF' data-tg-on='ON' for='cb3'></label>
  </li>
  <li class='tg-list-item'>
    <h4>灯 1</h4>
    <input class='tgl tgl-ios' id='cb1' name="led" type='checkbox' value="led1" onclick="changeStatus()"
    	<%  if(led1.equals("on"))
    		{  
    	%>
    		checked="checked"
    	<%  } 
		%>
    	<%-- <c:if test="${led1 eq 'on'}">checked=checked</c:if>
    	<c:if test="${led1 eq 'on'}">unchecked</c:if> --%>
    >
    <label class='tgl-btn' for='cb1'></label>
  </li>
  <li class='tg-list-item'>
    <h4>灯 2</h4>
    <input class='tgl tgl-ios' id='cb2' name="led" type='checkbox' value="led2" onclick="changeStatus()"
    	<%  if(led2.equals("on"))
    		{  
    	%>
    		checked="checked"
    	<%  } 
		%>
    	<%-- <c:if test="${led1 eq 'on'}">checked=checked</c:if>
    	<c:if test="${led1 eq 'on'}">unchecked</c:if> --%>
    >
    <label class='tgl-btn' for='cb2'></label>
  </li>
</ul>
</form>
  <script src="js/index.js"></script>
<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
<script>
	function changeStatus(){
		document.getElementById("ControllerForm").submit();
	}
</script>

</div>
</body>
</HTML>