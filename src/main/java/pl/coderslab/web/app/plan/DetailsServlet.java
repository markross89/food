package pl.coderslab.web.app.plan;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.*;
import pl.coderslab.web._helpers.PlanDetailsHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


@WebServlet(name = "AppPlanDetails", value = "/app/plan/details")
public class DetailsServlet extends HttpServlet {
	final PlanDao planDao = new PlanDao();
	final RecipePlanDao recipePlanDao = new RecipePlanDao();

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		try {
			int planId = Integer.parseInt(id);
			Plan plan = planDao.read(planId);
			List<RecipePlanDetails> recipePlanDetails = recipePlanDao.findRecipePlanDetails(planId);
			request.setAttribute("plan", plan);
			Map<String, List<RecipePlanDetails>> recipePlanDetailsByDay = PlanDetailsHelper.groupByDay(recipePlanDetails);
			request.setAttribute("recipePlanDetailsByDay", recipePlanDetailsByDay);
			getServletContext().getRequestDispatcher("/appPlanDetails.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid recipe plan id");
		}
	}
	
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
