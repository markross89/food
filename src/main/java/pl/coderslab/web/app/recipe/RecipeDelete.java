package pl.coderslab.web.app.recipe;

import pl.coderslab.dao.NotAvailableException;
import pl.coderslab.dao.RecipeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecipeDelete", value = "/app/recipe/delete")
public class RecipeDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipeId = request.getParameter("id");
        request.setAttribute("recipeId",recipeId);
        request.getServletContext().getRequestDispatcher("/confirmDelete.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        String recipeId = request.getParameter("recipeId");
        try{
            int _recipeId = Integer.parseInt(recipeId);
            recipeDao.delete(_recipeId);
        }catch(NumberFormatException e){
            e.printStackTrace();
        } catch (NotAvailableException e) {
            response.sendRedirect("/recipeDeleteError.jsp");
            return;
        }

        response.sendRedirect("/app/recipe/list");
    }
}
