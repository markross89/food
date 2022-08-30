package pl.coderslab.web.app.user;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUser", value = "/app/user/edit")
public class EditUser extends HttpServlet {
    final AdminDao adminDao = new AdminDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/app-edit-user-data.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        Admin loggedUser = (Admin) session.getAttribute("User");

        int userId = loggedUser != null ? loggedUser.getId() : 0;

        Admin admin = new Admin();
        admin.setId(userId);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setSuperadmin(0);
        admin.setEnable(1);
        adminDao.update(admin);
        session.setAttribute("User", admin);
        response.sendRedirect("/app/dashboard");

    }
}
