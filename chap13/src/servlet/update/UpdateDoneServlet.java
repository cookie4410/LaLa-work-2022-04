package servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmpLogic;
import util.GetParam;

@WebServlet("/updateDone")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.recive(request);
		String msg = (new UpdateEmpLogic().execute(emp))
				? "更新しました。"
				: "更新に失敗しました。";
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/update/updateDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
