package pl.coderslab.web.app.recipe;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddRecipe", value = "/app/recipe/add")
public class AddRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/AddRecipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        long millis =System.currentTimeMillis();
        Date date = new Date(millis);
        HttpSession session = request.getSession();
        Admin loggedUser = (Admin) session.getAttribute("User");

        String recipeName = request.getParameter("name");
        String description = request.getParameter("description");
        String _time = request.getParameter("time");
        int time = Integer.parseInt(_time);
        String preparing = request.getParameter("preparing");
        String ingredients = request.getParameter("ingredients");


        Recipe recipe = new Recipe();

        recipe.setName(recipeName);
        recipe.setDescription(description);
        recipe.setPreparationTime(time);
        recipe.setPreparation(preparing);
        recipe.setIngredients(ingredients);
        recipe.setAdminId(loggedUser.getId());
        recipe.setCreated(date);

        recipeDao.create(recipe);

        response.sendRedirect(request.getContextPath() + "/app/recipe/list");
    }
}
