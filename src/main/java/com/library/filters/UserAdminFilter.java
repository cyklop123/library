package com.library.filters;

import com.library.enums.Role;
import com.library.models.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserAdminFilter")
public class UserAdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        User user = (User) context.getAttribute("user");
        if(!user.getRole().equals(Role.ADMIN))
        {
            ((HttpServletResponse)response).sendRedirect("dashboard");
        }
        chain.doFilter(request, response);
    }
}
