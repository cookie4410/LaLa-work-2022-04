package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hantei;
import model.PlayResult;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request,
			             HttpServletResponse response)
			       throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int user = Integer.parseInt(request.getParameter("hand"));
		int com = (int) (Math.random() * 3);
		PlayResult result = new PlayResult(user, com);
		Hantei.exec(result);
		
		request.setAttribute("result", result);

		String url = "/WEB-INF/jsp/result.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	}

}
