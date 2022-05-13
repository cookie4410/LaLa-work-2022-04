package servlet.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpByIdLogic;

@WebServlet("/searchId")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/search/searchFailed.jsp";
		String id = request.getParameter("id");
		request.setAttribute("key", id);
		id = id.toUpperCase();
		
		 if (Pattern.matches("^EMP[0-9]{3}$", id)) {
			List<Employee> empList = new ArrayList<Employee>();
			empList.add(new FindEmpByIdLogic().execute(id));
			if (empList.size() != 0) {
				request.setAttribute("empList", empList);
				url = "/WEB-INF/jsp/search/search.jsp";
			}
		 }
		 request.getRequestDispatcher(url).forward(request, response);
	}

}
