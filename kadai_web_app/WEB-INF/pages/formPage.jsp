<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Objects" %>
<html>
	<head>
		<title>Servlet/JSP課題</title>
	</head>
	<body>
		<%
			String name = (String)request.getAttribute("name");
			String email = (String)request.getAttribute("email");
			String address = (String)request.getAttribute("address");
			String phone_number = (String)request.getAttribute("phone_number");

		
			name = Objects.toString(name, "");
			email = Objects.toString(email, "");
			address = Objects.toString(address, "");
			phone_number = Objects.toString(phone_number, "");
			

			
		%>
		<h2 style="font-family: serif">個人情報入力フォーム</h2>
		<form action="<%= request.getContextPath() %>/confirm" method="POST">
			<table>
				<tr>
					<th style="text-align:left;font-family:serif">氏名</th>
					<td><input type="text" name="name" value=<%= name %>></td>
				</tr>
				<tr>
					<th style="text-align:left;font-family:serif">メールアドレス</th>
					<td><input type="text" name="email" value="<%= email %>"></td>
				</tr>
				<tr>
					<th style="text-align:left;font-family:serif">住所</th>
					<td><input type="text" name="address" value="<%= address %>"></td>
				</tr>
				<tr>
					<th style="text-align:left;font-family:serif">電話番号</th>
					<td><input type="text" name="phone_number" value="<%= phone_number %>"></td>
				</tr>
			</table>
			<input type="submit" value="送信">
		</form>
	</body>
</html>
					
				