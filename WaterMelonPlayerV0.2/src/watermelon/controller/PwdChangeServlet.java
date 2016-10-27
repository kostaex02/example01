package watermelon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.Service.UserService;
import watermelon.dto.User;

@SuppressWarnings("serial")
@WebServlet("/pwdChange")
public class PwdChangeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//넘어온 현재비밀번호(oldPwd), 새로운비밀번호(newPwd)를 비교
		//일치할경우 비밀번호 변경 후 메인으로 이동.
		User user = (User) request.getSession().getAttribute("User");
		String id = user.getUserId();
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		if (UserService.pwdChange(id, oldPwd, newPwd)) {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			//???
		}
		
		
	}

}
