package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hantei;
import util.Validate;

@WebServlet("/play")
public class HiLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = this.getServletContext();
		Integer number = (Integer) application.getAttribute("number");
		if (number == null) {
			number = (int) (Math.random() * 100);
			application.setAttribute("number", number);
		}
		System.out.println("number:" + number);
		
		String url = "/WEB-INF/jsp/input.jsp";
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numtxt = request.getParameter("number");
		int num = Validate.getNumber(numtxt);
		String msg = "";
		
		if(num > 0) {
			ServletContext application = this.getServletContext();
			int number = (Integer) application.getAttribute("number");

			msg = Hantei.execute(num, number);
			if (msg.equals("正解です")) {
				application.removeAttribute("number");
			}
		} else {
			msg = "数字を入力してください";
		}
		
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/result.jsp";
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
