package player;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Song;
import net.sf.json.JSONArray;

@SuppressWarnings("serial")
@WebServlet("/deleteListServlet")
public class DeleteListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//한글을 받기위한 인코딩
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//전송된 곡목록 받기
		@SuppressWarnings("unchecked")
		ArrayList<Song> list = (ArrayList<Song>) request.getSession().getAttribute("list");
		//전송된 인덱스번호 받기
		String indexs = request.getParameter("indexs");
		System.out.println(indexs);
		//인덱스번호에서 구분자(|) 제거하고 해당 인덱스번호에 해당하는 곡목록 인덱스순위뒤바꿈
				StringTokenizer stringTokenizer = new StringTokenizer(indexs, "|");
//				int length = stringTokenizer.countTokens();
//				System.out.println("총 배열수: "+length);
				while (stringTokenizer.hasMoreTokens()) {
					int value = Integer.parseInt(stringTokenizer.nextToken());
					System.out.println("반복문 안: "+value);
					switch (value) {
					//체크박스에 체크가 되어있고 재생중인 곡이 아닐때,
						case 0: {
							int index = stringTokenizer.countTokens();
							System.out.println("인덱스번호: "+index);
							System.out.println(list.get(index).getSongName());
							list.remove(index);
							break;
						}
						case 1: {
							int index = stringTokenizer.countTokens();
							System.out.println("인덱스번호: "+index);
							System.out.println(list.get(index).getSongName());
							list.remove(index);
							break;
						}
						case 2: {
							int index = stringTokenizer.countTokens();
							System.out.println("인덱스번호: "+index);
							System.out.println(list.get(index).getSongName());
							list.get(index).setIsPlay(0);
							break;
						}
						case 3:{
							int index = stringTokenizer.countTokens();
							System.out.println("인덱스번호: "+index);
							System.out.println(list.get(index).getSongName());
							list.get(index).setIsPlay(1);
							break;
						}
					}
				}
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.println(jsonArray);
	}

}
