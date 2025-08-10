<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Objects" %>
<html>
	<head>
		<title>Servlet/JSP課題</title>
	</head>
	<body>
		<%
			String userName = (String)request.getAttribute("name");
			String userEmail = (String)request.getAttribute("email");
			String userAddress = (String)request.getAttribute("address");

		
			userName = Objects.toString(userName, "");
			userEmail = Objects.toString(userEmail, "");
			userAddress = Objects.toString(userAddress, "");
			

			
		%>
		<h2 style="font-family: serif">個人情報入力ホーム</h1>
		<form action="<%= request.getContextPath() %>/confirm" method="POST">
			<table>
				<tr>
					<th style="text-align:left;font-family:serif">氏名</th>
					<td><input type="text" name="name" value=<%= userName %>></td>
				</tr>
				<tr>
					<th style="text-align:left;font-family:serif">メールアドレス</th>
					<td><input type="text" name="email" value="<%= userEmail %>"></td>
				</tr>
				<tr>
					<th style="text-align:left;font-family:serif">住所</th>
					<td><input type="text" name="address" value="<%= userAddress %>"></td>
				</tr>
				<tr>
					<th style="text-align:left;font-family:serif">電話番号</th>
					<td><input type="text" name="phone_number"></td>
				</tr>
			</table>
			<input type="submit" value="送信">
		</form>
	</body>
</html>
					
				