package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//入力内容の取得
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone_number = request.getParameter("phone_number");
		
		name = Objects.toString(name, "");
		email = Objects.toString(email, "");
		address = Objects.toString(address, "");
		phone_number = Objects.toString(phone_number, "");
		
		//エラーリストの作成
		ArrayList<String> errorList = new ArrayList<String>();
		
		//バリデーション
		if("".equals(name)) {
			errorList.add("氏名を入力してください");
		}
		if("".equals(email)) {
			errorList.add("メールアドレスを入力してください");
		}else if(!email.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) {
			errorList.add("メールアドレス形式が正しくありません");
		}
		if("".equals(address)) {
			errorList.add("住所を入力してください");
		}
		if("".equals(phone_number)){
			errorList.add("電話番号を入力してください");
		}else if(!phone_number.matches("^[0-9]+-[0-9]+-[0-9]+$")) {
			errorList.add("電話番号の入力形式が正しくありません");
		}
		
		
		//エラーがあった場合リクエストスコープにセット
		if(!errorList.isEmpty()) {
			request.setAttribute("errorList", errorList);
		}
		
		//入力内容をリクエストスコープにセット
		request.setAttribute("name",name);
		request.setAttribute("address", address);
		request.setAttribute("email", email);
		request.setAttribute("phone_number", phone_number);
		
		//セッションにデータ保存
		HttpSession session = request.getSession();
		
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		session.setAttribute("address", address);
		session.setAttribute("phone_number", phone_number);
		
		setCookie(response, "name", name);
		setCookie(response, "email", email);
		setCookie(response, "address", address);
		setCookie(response, "phone_number", phone_number);
		
		//フォワード遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
		dispatcher.forward(request, response);
	}
	public void setCookie(HttpServletResponse response, String name, String value) {
		
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);
	}
}
