package elec.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elec.model.ElectronicsService;

public class DeleteElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelNum = request.getParameter("model_num");
		String flag = request.getParameter("flag");
		String password = request.getParameter("password");
		
		boolean state = true;
		if (flag != null)
			state = false;

		try {
			if(ElectronicsService.delete(modelNum,password) > 0){
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
