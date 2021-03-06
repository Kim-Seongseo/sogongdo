package TouristSite_Mgmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TouristSite_Mgmt.persistance.TouristSiteDAO;
import TouristSite_Mgmt.persistance.TouristSiteDTO;

@WebServlet("/TouristSite/enroll")
public class RegisterTouristSiteController extends HttpServlet {
	
	private TouristSiteDAO ts = new TouristSiteDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		String tourist_site_name = request.getParameter("tourist_site_name");
		TouristSiteDTO temp = new TouristSiteDTO(tourist_site_name);
		ts.insertTouristSite(temp);

		response.sendRedirect("/SogongDo_Management_System/TouristSite/view");
	}
}