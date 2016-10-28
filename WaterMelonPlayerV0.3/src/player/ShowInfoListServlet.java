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
@WebServlet("/showInfoListServlet")
public class ShowInfoListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ѱ��� �ޱ����� ���ڵ�
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//���۵� ���� �ޱ�
		@SuppressWarnings("unchecked")
		ArrayList<Song> list = (ArrayList<Song>) request.getSession().getAttribute("list");
		//���۵� ������ΰ� url�ޱ�
		String url = request.getParameter("playing");
		//����Ʈ ������ �ش� url�� ���� ��ü��ã��
		ArrayList<Song> data = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String urlList = list.get(i).getUrl();
			if (urlList.equals(url)) {
				data.add(list.get(i));
				break;
			}
		}
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(data);
		out.println(jsonArray);
	}

}
