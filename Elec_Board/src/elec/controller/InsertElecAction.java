package elec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import elec.model.ElectronicsService;
import elec.model.dto.Electronics;

public class InsertElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일첨부때문에 multipartRequest필요
		String saveDir = request.getSession().getServletContext().getRealPath("/save");
		
		int maxSize = 1024 * 1024 * 100; //100m
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		Electronics elec = new Electronics(modelNum,modelName,Integer.parseInt(price),description,password);
		
		if(m.getParameter("file") != null){
			System.out.println(m.getParameter("file"));
			elec.setfName(m.getFilesystemName("file"));
			elec.setfSize((int)m.getFile("file").length());
		}else{
			System.out.println(m.getParameter("file"));
			elec.setfName(null);
			elec.setfSize(0);
		}
		
		try {
			if(ElectronicsService.insert(elec) > 0){
				response.sendRedirect("elec?command=select");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
		
	}

}
