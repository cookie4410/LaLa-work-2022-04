package ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Fruit f = new Fruit("いちご", 700);
//	request.setAttribute("fruit", f);
//	request.getSession().setAttribute("fruit", f);
	this.getServletContext().setAttribute("fruit", f);
	request.getRequestDispatcher("/WEB-INF/ex/fruit.jsp").forward(request, response);
	}
}
