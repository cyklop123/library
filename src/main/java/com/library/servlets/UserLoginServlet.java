package com.library.servlets;

import com.library.enums.Role;
import com.library.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    Map<String,String> users;
    public void init()
    {
        users = Map.of(
                "user", "user",
                "test", "test",
                "john", "snow"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        if(checkUser(login, pass))
        {
            ServletContext context = request.getServletContext();
            context.setAttribute("user", new User(login, pass));
            response.sendRedirect("dashboard");
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginFailed.html");
            dispatcher.forward(request, response);
        }
    }

    protected boolean checkUser(String login, String pass)
    {
        return (users.containsKey(login) && users.get(login).equals(pass)) ? true:false;
    }
}
