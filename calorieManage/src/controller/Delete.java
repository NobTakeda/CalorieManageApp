package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CalDAO;
import model.Food;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String date=request.getParameter("date");
		CalDAO dao=new CalDAO();
		if(id != null) {
			dao.deleteFood(Integer.parseInt(id));
		}
		List<Food> list=dao.findToday(date);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/manage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
