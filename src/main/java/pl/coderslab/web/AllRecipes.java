package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/allRecipes")
public class AllRecipes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        request.setAttribute("recipes", recipeDao.findAll());
        request.getServletContext().getRequestDispatcher("/AllRecipesList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        RecipeDao recipeDao = new RecipeDao();
        Recipe recipe = recipeDao.readByName(name);
        if (recipe.getName() == null || recipe.getName().isBlank()) {
            response.sendRedirect(request.getContextPath() + "/allRecipes");
        } else {
            request.setAttribute("recipe", recipe);
            request.getServletContext().getRequestDispatcher("/displayRecipeByName.jsp").forward(request, response);
        }
    }
}
