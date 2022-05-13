package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmpListLogic;
import model.GetSizeLogic;
import util.Const;

@WebServlet("/list")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int last = (int)Math.ceil(new GetSizeLogic().execute() / (Const.PER_PAGE * 1.));
		request.setAttribute("last", last);
		
		int page = myParseInt(request.getParameter("page"));
		request.setAttribute("page", getPage(page, last));
		
		GetEmpListLogic ListLogic = new GetEmpListLogic();
		int skip = (page - 1) * Const.PER_PAGE;
		List<Employee> empList = ListLogic.execute(skip, Const.PER_PAGE);
		request.setAttribute("empList", empList);
		
		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private int getPage(int page, int last) {
		if(page < 1) {
			return 1;
		} else if(page > last) {
			return last;
		}
		return page;
	}
	
	private int myParseInt(String _page) {
		int page = 0;
		try {
			page = Integer.parseInt(_page);
		} catch(NumberFormatException e) {
			page = 1;
		}
		return page;
	}

}
