package pl.coderslab.web;

import pl.coderslab.dao.ContactDao;
import pl.coderslab.model.ContactObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LandingPageServlet", value = "")
public class LandingPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        ContactDao contactDao = new ContactDao();
        ContactObject contact =  contactDao.read();
        request.setAttribute("contact", contact);
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
