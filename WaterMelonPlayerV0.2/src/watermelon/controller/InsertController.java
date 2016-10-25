package watermelon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.Service.UserService;
import watermelon.dto.User;

@WebServlet("/insert")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String name  = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		PrintWriter out= response.getWriter();
		
		int i ;
		if(gender.equals("male")){
			i=1;
		}else{
			i=0;
		}
			
		User user = new User(email,pwd,name,birth,i,0);
		
		UserService service =new UserService();
		 if (service.insert(user)){
			 out.println("<script>");
			 out.println("alert('회원가입 성공')");
			 out.println("</script>");
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }else{
			 out.println("<script>");
			 out.println("alert('회원가입 성공')");
			 out.println("</script>");
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }
		
	}

}
