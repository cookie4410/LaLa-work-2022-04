package servlet.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.InsertEmpLogic;
import util.GetParam;

@WebServlet("/register")
public class RegisterEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.recive(request);
		InsertEmpLogic logic = new InsertEmpLogic();
		String msg = (logic.execute(emp)) ? "登録しました。" : "登録に失敗しました。";
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/create/registerDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
