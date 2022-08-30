package pl.coderslab.web.app.plan;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

@WebServlet(name = "EditServlet", value = "/app/plan/edit")
public class EditServlet extends HttpServlet {
    final PlanDao planDao = new PlanDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _planId = request.getParameter("id");
        try {
            Plan planToEdit = planDao.read(Integer.parseInt(_planId));
            request.setAttribute("plan", planToEdit);
            request.getServletContext().getRequestDispatcher("/appPlanEdit.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(SC_BAD_REQUEST, "Invalid plan number");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _planName = request.getParameter("planName");
        String _planDescription = request.getParameter("planDescription");
        String _planId = request.getParameter("planId");
        try {
            Plan planToEdit = planDao.read(Integer.parseInt(_planId));
            planToEdit.setName(_planName);
            planToEdit.setDescription(_planDescription);
            planDao.update(planToEdit);
            response.sendRedirect("/app/plan/list");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(SC_BAD_REQUEST, "Invalid plan number");
        }
    }
}
