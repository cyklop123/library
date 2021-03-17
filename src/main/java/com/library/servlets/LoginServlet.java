package com.library.servlets;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher;
        if("admin".equals(request.getParameter("login")))
            dispatcher = request.getRequestDispatcher("AdminLoginServlet");
        else
            dispatcher = request.getRequestDispatcher("UserLoginServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WelcomeServlet");
        dispatcher.forward(req, resp);
    }
}