package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class Ex62 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			              HttpServletResponse response) 
					throws ServletException, IOException {
		
		int num = (int) (Math.random() * 10);
		if (num % 2 == 1) {
			String url = "/ex/redirected.jsp";
			response.sendRedirect(url);
		} else {
			String url = "/forwarded.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
