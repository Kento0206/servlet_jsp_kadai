package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Cookie[] cookies = request.getCookies();
		
		
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				switch(cookie.getName()) {
				case "name" -> {
					request.setAttribute("name", cookie.getValue());
				}
				case "email" -> {
					request.setAttribute("email", cookie.getValue());
				}
				case "address" -> {
					request.setAttribute("address", cookie.getValue());
				}
				case "phone_number" -> {
					request.setAttribute("phone_number", cookie.getValue());
				}
				
				default -> {}
				}
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/formPage.jsp");
		dispatcher.forward(request, response);
	}
}
