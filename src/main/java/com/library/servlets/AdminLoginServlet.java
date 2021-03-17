package com.library.servlets;

import com.library.enums.Role;
import com.library.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        if("admin".equals(request.getParameter("login"))
                && "admin".equals(request.getParameter("pass")))
        {
            ServletContext context = request.getServletContext();
            context.setAttribute("user", new User("admin", "admin", Role.ADMIN));
            dispatcher = request.getRequestDispatcher("adminDashboard");
        }
        else
            dispatcher = request.getRequestDispatcher("loginFailed.html");
        dispatcher.forward(request, response);
    }
}
