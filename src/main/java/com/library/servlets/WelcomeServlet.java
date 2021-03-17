package com.library.servlets;

import com.library.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        RequestDispatcher dispatcher;
        System.out.println(context.getAttribute("user"));
        if(context.getAttribute("user") != null)
            dispatcher = request.getRequestDispatcher("dashboard");
        else
            dispatcher = request.getRequestDispatcher("login.html");
        dispatcher.forward(request, response);
    }
}
