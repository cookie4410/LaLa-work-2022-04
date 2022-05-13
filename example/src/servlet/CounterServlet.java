package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		
//		Integer count = 0;
//		ServletContext app = config.getServletContext();
//		app.setAttribute("count", count);
//		System.out.println("init() executed...success!");
//	}

//	public void destroy() {
//		System.out.println("destroy() executed...success!");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = this.getServletContext();
		Integer count = (Integer) app.getAttribute("count");
		count++;
		app.setAttribute("count", count);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>訪問回数を表示</title></head>");
		out.println("<body>");
		out.println("<p>訪問回数: " + count + "</p>");
		out.println("<a href=\"/example/CounterServlet\">更新</a>");
		out.println("</body></html>");
	}

}
