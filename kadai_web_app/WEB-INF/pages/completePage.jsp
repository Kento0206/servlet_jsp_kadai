<%@ page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>Servlet/JSP課題</title>
	</head>
	<body>
		<h2>個人情報入力が完了しました。</h2>
		<button onclick="location.href='<%= request.getContextPath() %>/form';">戻る</button>
		
	</body>
</html>