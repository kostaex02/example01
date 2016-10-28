package watermelon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import watermelon.Service.SelectUser;
import watermelon.dto.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectUser service = new SelectUser();
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		User user = service.login(email, pwd);
		HttpSession session = request.getSession();
		session.setAttribute("User", user);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
