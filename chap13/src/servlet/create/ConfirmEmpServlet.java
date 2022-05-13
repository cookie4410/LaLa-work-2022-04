package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import util.GetParam;

@WebServlet("/confirm")
public class ConfirmEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.recive(request);
		request.setAttribute("emp", emp);
		
		String url = "/WEB-INF/jsp/create/confirmEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
