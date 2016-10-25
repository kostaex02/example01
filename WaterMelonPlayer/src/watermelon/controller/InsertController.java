package watermelon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import watermelon.Service.UserService;
import watermelon.dao.UserDAO;
import watermelon.dto.User;

@WebServlet("/insert")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String name  = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		PrintWriter out= response.getWriter();
		Date date = null;
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyMMdd");
		try {
			date = format.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i ;
		if(gender.equals("male")){
			i=1;
		}else{
			i=0;
		}
			
		User user = new User(email,pwd,name,date,i,0);
		
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
