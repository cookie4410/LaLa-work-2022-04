package glicote.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import glicote.model.bean.GameDataBean;
import glicote.model.manager.CoreManager;
import glicote.util.Hands;

@WebServlet("/glicote")
public class GlicoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("gameData", new GameDataBean());
		String url = "/WEB-INF/jsp/glicote/glicote.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GameDataBean gameData = (GameDataBean)session.getAttribute("gameData");
		int count = Hands.valueOf(gameData.getWinnerHand()).getText().length();;
		System.out.println("servlet");
		if(gameData.getWinner() == "user") {
			gameData.setUserStep(gameData.getUserStep() + count);
		} else if(gameData.getWinner() == "com") {
			gameData.setComStep(gameData.getComStep() + count);
		}
		
		Hands userHand = Hands.valueOf(request.getParameter("hand"));
		int result = CoreManager.judge(userHand.getId());
		
		gameData.setWinnerHand(userHand.name());
		System.out.println(gameData.getUserStep());
		
		session.setAttribute("gameData", gameData);
		String url = "/WEB-INF/jsp/glicote/glicote.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
