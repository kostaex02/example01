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

import net.sf.json.JSONArray;
import watermelon.dto.Song;

@SuppressWarnings("serial")
@WebServlet("/downListServlet")
public class DownListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ѱ��� �ޱ����� ���ڵ�
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//���۵� ���� �ޱ�
		@SuppressWarnings("unchecked")
		ArrayList<Song> list = (ArrayList<Song>) request.getSession().getAttribute("list");
		//���۵� �ε�����ȣ �ޱ�
		String indexs = request.getParameter("indexs");
		System.out.println(indexs);
		//�ε�����ȣ���� ������(|) �����ϰ� �ش� �ε�����ȣ�� �ش��ϴ� ���� �ε��������ڹٲ�
		StringTokenizer stringTokenizer = new StringTokenizer(indexs, "|");
		int length = stringTokenizer.countTokens();
//		System.out.println("�� �迭��: "+length);
		while (stringTokenizer.hasMoreTokens()) {
			int value = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println("�ݺ��� ��: "+value);
			switch (value) {
			//üũ�ڽ��� üũ�� �Ǿ��ְ� ������� ���� �ƴҶ�,
				case 0: {
					int index = stringTokenizer.countTokens();
					System.out.println("�ε�����ȣ: "+index);
					System.out.println(list.get(index).getSongName());
					list.get(index).setIsPlay(0);
					list.get(index).setIsChecked(1);
					if (index<length-1) {
						int numChange = index+1;
						if (list.get(numChange).getIsChecked()==1) {
							break;
						}
						Song song = list.get(numChange);
						list.set(numChange, list.get(index));
						list.set(index, song);
					}	
					break;
				}
				case 1: {
					int index = stringTokenizer.countTokens();
					System.out.println("�ε�����ȣ: "+index);
					System.out.println(list.get(index).getSongName());
					list.get(index).setIsPlay(1);
					list.get(index).setIsChecked(1);
					if (index<length-1) {
						int numChange = index+1;
						if (list.get(numChange).getIsChecked()==1) {
							break;
						}
						Song song = list.get(numChange);
						list.set(numChange, list.get(index));
						list.set(index, song);
					}
					break;
				}
				case 2: {
					int index = stringTokenizer.countTokens();
					System.out.println("�ε�����ȣ: "+index);
					System.out.println(list.get(index).getSongName());
					list.get(index).setIsPlay(0);
					list.get(index).setIsChecked(0);
					break;
				}
				case 3:{
					int index = stringTokenizer.countTokens();
					System.out.println("�ε�����ȣ: "+index);
					System.out.println(list.get(index).getSongName());
					list.get(index).setIsPlay(1);
					list.get(index).setIsChecked(0);
					break;
				}
			}
		}
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.println(jsonArray);
	}

}
