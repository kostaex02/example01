package elec.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����÷�ζ����� multipartRequest�ʿ�
		String saveDir = request.getSession().getServletContext().getRealPath("/save");
		
		int maxSize = 1024 * 1024 * 100; //100m
		String encoding="UTF-8";
		
	}

}
