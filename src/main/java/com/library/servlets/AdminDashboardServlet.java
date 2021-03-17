package com.library.servlets;

import com.library.models.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminDashboardServlet", value = "/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
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
        writer.println("<h1>Add book</h1>");
        writer.println("<form method='POST'>");
        writer.println("<input type='hidden' name='action' value='add'><br>");
        writer.println("Title <input type='text' name='title'><br>");
        writer.println("Author <input type='text' name='author'><br>");
        writer.println("Year <input type='number' name='year'><br>");
        writer.println("<button>Add</button>");
        writer.println("</form>");
        writer.println("<h1>Delete book</h1>");
        writer.println("<form method='POST'>");
        writer.println("<input type='hidden' name='action' value='delete'><br>");
        writer.println("Enter deleted book title <input type='text' name='title'><br>");
        writer.println("<button>Delete</button>");
        writer.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletContext context = request.getServletContext();
        List<Book> books = (ArrayList<Book>) context.getAttribute("books");
        String action = request.getParameter("action");
        if("add".equals(action))
        {
            String title = (request.getParameter("title") != null) ? request.getParameter("title"):"";
            String author = (request.getParameter("author") != null) ? request.getParameter("author"):"";
            String year = (request.getParameter("year") != null) ? request.getParameter("year"):"";
            if(!title.equals("") && !author.equals("") && !year.equals("")) {
                Book book = new Book(title, author, Integer.parseInt(year));
                books.add(book);
            }
        }
        else if("delete".equals(action))
        {
            String title = (request.getParameter("title") != null) ? request.getParameter("title") : "";
            books.removeIf(book -> (book.getTitle().equals(title)));
        }

        this.doGet(request, response);
    }
}
