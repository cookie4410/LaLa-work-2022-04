package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testenq")
public class TestEnq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, 
			               HttpServletResponse response) 
					throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String qtype = request.getParameter("qtype");
		String body = request.getParameter("body");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("名前:" + name);
		out.println("種類:" + qtype);
		out.println("内容:" + body);
		out.println("</body></html>");
	}

}
