package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/MinatoIndex")
public class MinatoIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
		
		if(siteEV == null) {
			siteEV = new SiteEV();
		}
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if(action != null && action.equals("like")) {
			SiteEVLogic.like(siteEV);
		}else if(action != null && action.equals("dislike")) {
			SiteEVLogic.dislike(siteEV);
		}
		
		application.setAttribute("siteEV", siteEV);
		
		String url = "/WEB-INF/jsp/minatoIndex.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
