package elec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elec.model.ElectronicsService;
import elec.model.dto.Electronics;

public class DetailViewElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		String modelNum = request.getParameter("modelNum");
		
		boolean flag = true;
		try{
			if(modelNum != null){
				Electronics elec = ElectronicsService.selectByModelNum(modelNum, flag);
				request.setAttribute("elec", elec);
				url = "read.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		//forward방식으로 read.jsp로 이동한다. 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
