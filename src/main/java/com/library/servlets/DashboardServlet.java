package com.library.servlets;

import com.library.models.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        List<Book> books = (List<Book>) request.getServletContext().getAttribute("books");
        PrintWriter writer = response.getWriter();
        writer.println("<ol>");
        for(Book b: books)
            writer.println("<li>" + b.toString() + "</li>");
        writer.println("</ol>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
