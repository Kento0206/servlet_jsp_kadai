<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
		<title>Servlet/JSP課題</title>
	</head>
	<body>
		<h1>入力内容をご確認ください</h1>
			<table border="1">
				<tr>
					<th>項目</th>
					<th>入力内容</th>
				</tr>
				<tr>
					<td>氏名</td>
					<td>${userName}</td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td>${userEmail}</td>
				</tr>
				<tr>
					<td>住所</td>
					<td>${userAddress}</td>
				</tr>
				<tr>
					<td>電話番号</td>
					<td>${userNumber}</td>
				</tr>
			</table>
			
			<button onclick="location.href='<%= request.getContextPath() %>/complete';">確定</button>
			<button onclick="history.back();">キャンセル</button>
		</form>
		<%
			ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
			
			if(errorList != null){
				for(String errorMessage:errorList){
					out.println("<br><font color= \"red\">" + errorMessage + "</font>");
				}
			}
		%>
	</body>
</html>