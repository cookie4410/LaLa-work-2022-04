package servlet.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpByNameLogic;

@WebServlet("/searchName")
public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/search/searchFailed.jsp";
		String name = request.getParameter("name");
		request.setAttribute("key", name);
		
		List<Employee> empList = new ArrayList<Employee>();
		if(name != "") {
			empList = new FindEmpByNameLogic().execute(name);
		}
		if (empList.size() != 0) {
			request.setAttribute("empList", empList);
			url = "/WEB-INF/jsp/search/search.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
