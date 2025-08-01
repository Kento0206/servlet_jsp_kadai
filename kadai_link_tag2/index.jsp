<%@ page  contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>Servlet/JSP課題</title>
	</head>
	<body>
		<a href="<%= request.getContextPath()%>/j2s2j?name=侍太郎">名前「侍太郎」をServletに送信</a>
		<p></p>
		<%
			String commonUser = (String)request.getAttribute("userName");
			if(commonUser != null){
				out.println(commonUser);
			}
		%>
	</body>
</html>
