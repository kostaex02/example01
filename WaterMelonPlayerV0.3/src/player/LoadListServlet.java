package player;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import watermelon.dto.Song;

@SuppressWarnings("serial")
@WebServlet("/loadListServlet")
public class LoadListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ѱ��� �ޱ����� ���ڵ�
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//���۵� ���� �ޱ�
		@SuppressWarnings("unchecked")
		ArrayList<Song> list = (ArrayList<Song>) request.getSession().getAttribute("list");
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.println(jsonArray);
	}

}
