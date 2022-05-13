package hitblow.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hitblow")
public class HitblowCore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/minigames/hitblowStart");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String level = request.getParameter("level");
		String num = request.getParameter("num");
		request.setAttribute("level", level);
		request.setAttribute("num", num);
		request.getRequestDispatcher("/WEB-INF/jsp/hitblow/hitblow.jsp").forward(request, response);
	}

}
