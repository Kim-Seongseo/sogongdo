package FacilityCharge_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FacilityCharge_Mgmt.persistance.FacilityChargeDAO;
import FacilityCharge_Mgmt.persistance.FacilityChargeDTO;

@WebServlet("/Facility/Charge/enroll")
public class EnrollFacilityChargeController extends HttpServlet{
	private FacilityChargeDAO FacilityChargeDAO = new FacilityChargeDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int touristSite = Integer.parseInt(req.getParameter("touristSite"));
		int facility = Integer.parseInt(req.getParameter("facility"));
		int charge = Integer.parseInt(req.getParameter("charge"));
		
		FacilityChargeDAO.insert(touristSite, facility, charge);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility/Charge/view");
		dispatcher.forward(req, resp);
	}
}