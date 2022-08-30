package pl.coderslab.web.app.plan;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "AppPlanList", value = "/app/plan/list")
public class ListServlet extends HttpServlet {
    private final PlanDao planDao = new PlanDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin currentUser = (Admin) session.getAttribute("User");
        List<Plan> allPlans = planDao.findAllByUser(currentUser.getId());
        allPlans.sort(Comparator.comparing(Plan::getCreated).reversed());
        request.setAttribute("plans", allPlans);
        request.getRequestDispatcher("/appPlanList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
