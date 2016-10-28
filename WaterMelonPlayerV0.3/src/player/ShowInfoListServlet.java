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
		//한글을 받기위한 인코딩
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//전송된 곡목록 받기
		@SuppressWarnings("unchecked")
		ArrayList<Song> list = (ArrayList<Song>) request.getSession().getAttribute("list");
		//전송된 재생중인곡 url받기
		String url = request.getParameter("playing");
		//리스트 내에서 해당 url과 같은 객체값찾기
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
