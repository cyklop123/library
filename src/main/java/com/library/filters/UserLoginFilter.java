package com.library.filters;

import com.library.enums.Role;
import com.library.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserLoginFilter")
public class UserLoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext context = servletRequest.getServletContext();
        User user = (User) context.getAttribute("user");
        if(user != null)
        {
            if(user.getRole().equals(Role.ADMIN))
            {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("adminDashboard");
                dispatcher.forward(servletRequest, servletResponse);
            }
            else
                filterChain.doFilter(servletRequest,servletResponse);
        }
        else
        {
            ((HttpServletResponse)servletResponse).sendRedirect("login.html");
        }
    }
}