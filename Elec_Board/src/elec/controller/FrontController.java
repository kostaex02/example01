package elec.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/elec")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Map<String,Action> map;
    public FrontController() {}

	@Override
	public void init() throws ServletException{
		map = (Map<String,Action>)super.getServletContext().getAttribute("map");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key;
		if(request.getParameter("command")==null){
			key="select";
		}else{
			key = request.getParameter("command");
		}
		Action ac = map.get(key);
		ac.execute(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
