package pl.coderslab.web.app.recipe.plan;

import pl.coderslab.dao.RecipePlanDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "DeleteServlet", value = "/app/recipe/plan/delete")
public class DeleteServlet extends HttpServlet {
	final RecipePlanDao recipePlanDao = new RecipePlanDao();
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recipePlanId = request.getParameter("id");
		String planId = request.getParameter("planId");

		request.setAttribute("recipePlanId", recipePlanId);
		request.setAttribute("planId", planId);
		request.getServletContext().getRequestDispatcher("/confirmDeleteRecipeFromPlan.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recipeId = request.getParameter("recipePlanId");
		String planId = request.getParameter("planId");
		try{
			int _recipePlanId = Integer.parseInt(recipeId);
			recipePlanDao.delete(_recipePlanId);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		response.sendRedirect("/app/plan/details?id=" + planId);
	}
}
