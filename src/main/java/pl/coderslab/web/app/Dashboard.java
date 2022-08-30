package pl.coderslab.web.app;

import pl.coderslab.dao.*;
import pl.coderslab.model.*;
import pl.coderslab.web._helpers.PlanDetailsHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@WebServlet(name = "Dashboard", value = "/app/dashboard")
public class Dashboard extends HttpServlet {

    private final PlanDao planDao = new PlanDao();
    private final RecipeDao recipeDao = new RecipeDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin loggedUser = (Admin) session.getAttribute("User");
        int id = loggedUser.getId();

        request.setAttribute("admin", loggedUser.getFirstName());
        request.setAttribute("plans", planDao.planCount(id));
        request.setAttribute("recipes",recipeDao.amountOfRecipesOfUser(id));

        RecipePlanDao recipePlanDao = new RecipePlanDao();
        try {
            Plan plan = planDao.lastAddedPlan(id);
            request.setAttribute("plan", plan);
            List<RecipePlanDetails> recipePlanDetails = recipePlanDao.findRecipePlanDetails(plan.getId());
            Map<String, List<RecipePlanDetails>> recipePlanDetailsByDay = PlanDetailsHelper.groupByDay(recipePlanDetails);
            request.setAttribute("recipePlanDetailsByDay", recipePlanDetailsByDay);
            getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid recipe plan id");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
