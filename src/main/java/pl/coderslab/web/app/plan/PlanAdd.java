package pl.coderslab.web.app.plan;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;



@WebServlet(name = "PlanAdd", value = "/app/plan/add")
public class PlanAdd extends HttpServlet {

	final PlanDao planDao = new PlanDao();

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/addSchedules.jsp").forward(request,response);


	}

	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String planName = request.getParameter("name");
		String planDescription = request.getParameter("description");
		HttpSession session = request.getSession();

		Admin user = (Admin) session.getAttribute("User");
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		Plan plan = new Plan();
		plan.setName(planName);
		plan.setDescription(planDescription);
		plan.setCreated(date);
		plan.setAdminId(user.getId());

		planDao.create(plan);
		response.sendRedirect(request.getContextPath() + "/app/plan/list");
	}
}
