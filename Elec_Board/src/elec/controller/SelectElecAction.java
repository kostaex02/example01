package elec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elec.model.ElectronicsService;
import elec.model.dto.Electronics;

public class SelectElecAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "error.jsp";
		try{
			List<Electronics> list = ElectronicsService.selectAll();
			
			//select의 결과(리턴값)을 scope영역에 저장한다.
			request.setAttribute("list", list);
			url = "list.jsp";
			
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		//forward방식으로 memberSelect.jsp로 이동한다. 
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
