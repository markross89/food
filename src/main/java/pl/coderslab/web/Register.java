package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/registration.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao adminDao = new AdminDao();
        Admin admin = new Admin();

        if(adminDao.findByEmail(request.getParameter("email")) != null){
            response.sendRedirect(request.getContextPath() + "/login/exists");

        }else{
            admin.setFirstName(request.getParameter("name"));
            admin.setLastName(request.getParameter("surname"));
            admin.setEmail(request.getParameter("email"));
            admin.setPassword(request.getParameter("password"));
            admin.setSuperadmin(0);
            admin.setEnable(1);
            adminDao.create(admin);
            response.sendRedirect(request.getContextPath() + "/login");
        }


    }
}
