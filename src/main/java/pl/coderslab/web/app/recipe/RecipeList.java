package pl.coderslab.web.app.recipe;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecipeList", value = "/app/recipe/list")
public class RecipeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        HttpSession session = request.getSession();
        Admin loggedUser = (Admin) session.getAttribute("User");

        int userId = loggedUser != null ? loggedUser.getId() : 0;
        request.setAttribute("recipes", recipeDao.findAllByUser(userId));
        request.getServletContext().getRequestDispatcher("/recipeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
