package watermelon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import watermelon.Service.ReviewService;
import watermelon.dto.Review;

/**
 * Servlet implementation class ReviewSelectController
 */
@WebServlet("/ReviewSelect")
public class ReviewSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<Review> list = new ArrayList<>();
		list = ReviewService.selectReviewAll();
		System.out.println(1);
		JSONArray jsonArr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
	}

}
