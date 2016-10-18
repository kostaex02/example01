package elec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elec.model.ElectronicsService;
import elec.model.dto.Electronics;

public class UpdateFormElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("model_num");
		boolean flag = false;
		
		try{
			Electronics elec = ElectronicsService.selectByModelNum(modelNum, flag);
			
			request.setAttribute("elec", elec);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}
}
