package servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteEmpLogic;

@WebServlet("/deleteDone")
public class DeleteDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean result = new DeleteEmpLogic().execute(id);
		String msg = "ID: " + id;
		msg += (result) ? "を削除しました。" : "を削除できませんでした。";
		request.setAttribute("msg", msg);
		String url = "/WEB-INF/jsp/delete/deleteDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
