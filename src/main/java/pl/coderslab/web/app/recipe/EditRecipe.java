package pl.coderslab.web.app.recipe;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/app/recipe/edit")
public class EditRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _id = request.getParameter("id");
        if (_id ==null || _id.isBlank()) {
            getServletContext().getRequestDispatcher("/recipeList.jsp").forward(request, response);
        } else {
            try {
                int userId = Integer.parseInt(_id);
                RecipeDao recipeDao = new RecipeDao();
                Recipe recipe = recipeDao.read(userId);
                request.setAttribute("recipe", recipe);
                getServletContext().getRequestDispatcher("/app-edit-recipe.jsp").forward(request, response);

            } catch (NumberFormatException e){
                getServletContext().getRequestDispatcher("/recipeList.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipe = new Recipe();
        long millis =System.currentTimeMillis();
        Date date = new Date(millis);
        recipe.setAdminId(Integer.parseInt(request.getParameter("adminId")));
        recipe.setName(request.getParameter("name"));
        recipe.setId(Integer.parseInt(request.getParameter("recipeId")));
        recipe.setDescription(request.getParameter("description"));
        recipe.setIngredients(request.getParameter("ingredients"));
        recipe.setPreparation(request.getParameter("preparation"));
        recipe.setPreparationTime(Integer.parseInt(request.getParameter("preparationTime")));
        recipe.setUpdated(date);

        RecipeDao recipeDao = new RecipeDao();
        recipeDao.update(recipe);
        response.sendRedirect(request.getContextPath() + "/app/recipe/list");
    }
}
