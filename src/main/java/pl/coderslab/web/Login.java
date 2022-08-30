package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    AdminDao adminDao = new AdminDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Admin userToAuthorize = adminDao.findByEmail((email));
        HttpSession session = request.getSession();

        if (userToAuthorize == null) {
            response.sendRedirect("/login");
            return;
        }

        int blockedUser = userToAuthorize.getEnable();
        boolean validPassword = adminDao.validPassword(userToAuthorize, password);
        if (validPassword && blockedUser !=0) {
            int superAdmin = userToAuthorize.getSuperadmin();
            session.setAttribute("User", userToAuthorize);
            session.setAttribute("Authorized", true);
            session.setAttribute("superAdmin",superAdmin);
            response.sendRedirect("/app/dashboard");
        } else {
            response.sendRedirect("/login");
        }
    }
}
