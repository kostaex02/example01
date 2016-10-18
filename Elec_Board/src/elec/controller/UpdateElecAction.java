package elec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elec.model.ElectronicsService;
import elec.model.dto.Electronics;

public class UpdateElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("model_num");
		String password = request.getParameter("password");
		String modelName = request.getParameter("model_name");
		String price = request.getParameter("price");
		String description = request.getParameter("description"); 
		request.setCharacterEncoding("UTF-8");
		
		try {
			Electronics elec = new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
			if(ElectronicsService.update(elec) > 0){
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
