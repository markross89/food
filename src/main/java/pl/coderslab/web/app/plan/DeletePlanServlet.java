package pl.coderslab.web.app.plan;

import pl.coderslab.dao.NotAvailableException;
import pl.coderslab.dao.PlanDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/app/plan/delete")
public class DeletePlanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String planId = request.getParameter("id");
        request.setAttribute("planId",planId);
        request.getServletContext().getRequestDispatcher("/confirmDeletePlan.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanDao planDao = new PlanDao();
        String _planId = request.getParameter("planId");

        try{
            int planId = Integer.parseInt(_planId);
            planDao.delete(planId);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return;
        } catch (NotAvailableException e) {
            response.sendRedirect("/planDeleteError.jsp");
            return;
        }
        response.sendRedirect("/app/plan/list");
    }
}
