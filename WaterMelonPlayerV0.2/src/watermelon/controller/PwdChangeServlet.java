package watermelon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

@SuppressWarnings("serial")
@WebServlet("/pwdChange")
public class PwdChangeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�Ѿ�� �����й�ȣ(oldPwd), ���ο��й�ȣ(newPwd)�� ��
		//��ġ�Ұ�� ��й�ȣ ���� �� �������� �̵�.
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
