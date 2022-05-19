package glicote.servlet;

import java.io.IOException;
import java.util.Random;

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
		System.out.println("servlet");
		HttpSession session = request.getSession();
		GameDataBean gameData = (GameDataBean)session.getAttribute("gameData");
		
		if(gameData.getWinnerHand() != null) {
			int count = Hands.valueOf(gameData.getWinnerHand()).getText().length();;
			if(gameData.getWinner() == "user") {
				gameData.setUserStep(gameData.getUserStep() + count);
			} else if(gameData.getWinner() == "com") {
				gameData.setComStep(gameData.getComStep() + count);
			}
		}
		
		int userHand = Hands.valueOf(request.getParameter("hand")).getId();
		System.out.println("userHand: " + String.valueOf(userHand));
		int comHand = new Random().nextInt(5) % 3;
		System.out.println("comHand: " + String.valueOf(comHand));
		String winner = CoreManager.judge(userHand, comHand);
		gameData.setWinner(winner);
		System.out.println("winner: " + winner);
		
		Hands[] values = Hands.values();
		if(winner == "user") {
			gameData.setWinnerHand(values[userHand].name());
		} else if(winner == "com") {
			gameData.setWinnerHand(values[comHand].name());
		} else {
			gameData.setWinnerHand(null);
		}
		
		session.setAttribute("gameData", gameData);
		String url = "/WEB-INF/jsp/glicote/glicote.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
