package pl.coderslab.web.app.recipe.plan;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddServlet", value = "/app/recipe/plan/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("User");
        int userId = user != null ? user.getId() : 0;

        PlanDao planDao = new PlanDao();
        List<Plan> plans = planDao.findAllByUser(userId);

        RecipeDao recipeDao = new RecipeDao();
        List<Recipe> recipes = recipeDao.findAllByUser(userId);

        DayNameDao dayNameDao = new DayNameDao();
        List<DayName> days = dayNameDao.findAll();

        request.setAttribute("plans", plans);
        request.setAttribute("recipes", recipes);
        request.setAttribute("days", days);

        request.getServletContext().getRequestDispatcher("/addRecipeToPlan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _planId = request.getParameter("choosePlan");
        String _mealName = request.getParameter("name");
        String _displayOrder = request.getParameter("number");
        String _recipeId = request.getParameter("recipe");
        String _dayId = request.getParameter("day");
        RecipePlanDao recipePlanDao = new RecipePlanDao();
        RecipePlan recipePlanToAdd = new RecipePlan();
        try {
            recipePlanToAdd.setPlanId(Integer.parseInt(_planId));
            recipePlanToAdd.setMealName(_mealName);
            recipePlanToAdd.setDisplayOrder(Integer.parseInt(_displayOrder));
            recipePlanToAdd.setRecipeId(Integer.parseInt(_recipeId));
            recipePlanToAdd.setDayNameId(Integer.parseInt(_dayId));
            recipePlanDao.create(recipePlanToAdd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/app/recipe/plan/add");
    }
}
