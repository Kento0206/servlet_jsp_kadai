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
		String userName = request.getParameter("name");
		String userEmail = request.getParameter("email");
		String userAddress = request.getParameter("address");
		String userNumber = request.getParameter("number");
		
		userName = Objects.toString(userName, "");
		userEmail = Objects.toString(userEmail, "");
		userAddress = Objects.toString(userAddress, "");
		userNumber = Objects.toString(userNumber, "");
		
		//エラーリストの作成
		ArrayList<String> errorList = new ArrayList<String>();
		
		//バリデーション
		if("".equals(userName)) {
			errorList.add("氏名を入力してください");
		}
		if("".equals(userEmail)) {
			errorList.add("メールアドレスを入力してください");
		}else if(!userEmail.matches("^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+$")) {
			errorList.add("メールアドレス形式が正しくありません");
		}
		if("".equals(userAddress)) {
			errorList.add("住所を入力してください");
		}
		if("".equals(userNumber)){
			errorList.add("電話番号を入力してください");
		}else if(!userNumber.matches("^[0-9]+-[0-9]+-[0-9]+$")) {
			errorList.add("電話番号の入力形式が正しくありません");
		}
		
		//エラーがあった場合リクエストスコープにセット
		if(!errorList.isEmpty()) {
			request.setAttribute("errorList", errorList);
		}
		
		//入力内容をリクエストスコープにセット
		request.setAttribute("userName", userName);
		request.setAttribute("userAddress", userAddress);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("userNumber", userNumber);
		
		//セッションにデータ保存
		HttpSession session = request.getSession();
		
		session.setAttribute("userName", userName);
		session.setAttribute("userEmail", userEmail);
		session.setAttribute("userAddress", userAddress);
		session.setAttribute("userNumber", userNumber);
		
		setCookie(response, "name", userName);
		setCookie(response, "email", userEmail);
		setCookie(response, "address", userAddress);
		
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
