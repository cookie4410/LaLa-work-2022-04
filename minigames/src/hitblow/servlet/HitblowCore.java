package hitblow.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hitblow.model.bean.ComBean;
import hitblow.model.bean.GameDataBean;
import hitblow.model.bean.LogBean;
import hitblow.model.manager.AiManager;
import hitblow.model.manager.CoreManager;
import hitblow.model.manager.LogManager;
import hitblow.model.manager.PoolManager;

@WebServlet("/hitblow")
public class HitblowCore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/minigames/hitblowStart");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			boolean isEnd = false;
			int result = 0x0;
			if(request.getParameter("level") != null) {
//				初回
				String level = request.getParameter("level");
				session.setAttribute("com", new ComBean(level));
				GameDataBean gameData = new GameDataBean(num);
				gameData.setComNum(PoolManager.getRandomNum(PoolManager.gen()));
				session.setAttribute("gameData", gameData);
				LogBean userLog = new LogBean();
				LogBean comLog = new LogBean();
				session.setAttribute("userLog", userLog);
				session.setAttribute("comLog", comLog);
			} else {
//				2回目以降
				ComBean com = (ComBean)session.getAttribute("com");
				GameDataBean gameData = (GameDataBean)session.getAttribute("gameData");
				LogBean userLog = (LogBean)session.getAttribute("userLog");
				LogBean comLog = (LogBean)session.getAttribute("comLog");
				
				int hitblow = CoreManager.countHitBlow(num, gameData.getComNum());
				LogManager.write(userLog, num, hitblow);
				int comAtkNum = AiManager.executeAI(com, gameData);
				int comHitblow = CoreManager.countHitBlow(comAtkNum, gameData.getUserNum());
				comLog.getHitblowLog().add(0, comHitblow);
				LogManager.write(comLog, comAtkNum, comHitblow);
				if(com.getLevel() != "EASY") {
					PoolManager.optimazation(com.getSecPool(), comLog);
				}
				
				if(hitblow == 30) {
					isEnd = true;
					result = result | 1;
				}
				if(comHitblow == 30) {
					isEnd = true;
					result = result | 2;
				}
				session.setAttribute("userLog", userLog);
			}
			
			if(isEnd) {
				GameDataBean gameData = (GameDataBean)session.getAttribute("gameData");
				request.setAttribute("result", result);
				request.setAttribute("gameData", gameData);
				request.setAttribute("userLog", session.getAttribute("userLog"));
				request.setAttribute("comLog", session.getAttribute("comLog"));
				String time = CoreManager.calcDuration(gameData.getStartAt(), System.currentTimeMillis());
				request.setAttribute("time", time);
				session.invalidate();
				request.getRequestDispatcher("/WEB-INF/jsp/hitblow/hitblowGameset.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/jsp/hitblow/hitblow.jsp").forward(request, response);
			}
		} catch(Exception e) {
			session.invalidate();
			response.sendRedirect("/minigames/hitblowError");
		}
	}

}
