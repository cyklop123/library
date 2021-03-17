package com.library.listener;

import com.library.models.Book;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class LibraryContextServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Eleonora Kalkowska","Głód życia",1904));
        books.add(new Book("Zofia Urbanowska", "Księżniczka",1886));
        books.add(new Book("Eliza Orzeszkowa", "Dobra pani", 1888));
        books.add(new Book("Gabriela Zapolska", "Kaśka Kariatyda", 1895));
        sce.getServletContext().setAttribute("books", books);
    }
}
