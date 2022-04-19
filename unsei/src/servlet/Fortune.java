package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Uranai;

@WebServlet("/fortune")
public class Fortune extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Uranai uranai = new Uranai();
		String word = uranai.getFortune();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<meta charset=\"utf-8\"");
		out.println("</head><body>");
		out.println("<p>今日のあなたの運勢: " + word + "</p>");
		out.println("</body></html");
	}

}
