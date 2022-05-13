package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Core;
import model.GameData;

@WebServlet("/play")
public class HighAndLow extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameData gd = new GameData(new Random().nextInt(98)+1);
		request.getSession().setAttribute("gd", gd);
		
		String url = "/WEB-INF/jsp/highAndLow.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/jsp/highAndLow.jsp";
		
		GameData gd = (GameData) request.getSession().getAttribute("gd");
		if(request.getParameter("num")!="") {
			int num = Integer.parseInt(request.getParameter("num"));
			request.setAttribute("check", Core.checkNum(num));
			if(Core.checkNum(num)) {
				Core.judge(gd, num);
				Core.stepCount(gd);
				Core.addLog(gd, num);
				request.getSession().setAttribute("gd", gd);
			}
		} else {
			request.setAttribute("check", false);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
