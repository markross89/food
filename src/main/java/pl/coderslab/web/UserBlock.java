package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserBlock", value = "/app/user/superAdmin/userBlock")
public class UserBlock extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        Admin admin;
        AdminDao adminDao = new AdminDao();
        admin = adminDao.read(Integer.parseInt(userId));
        admin.setEnable(0);
        adminDao.update(admin);
        response.sendRedirect("/app/user/superAdmin");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
