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
        List<Book> books = List.of(
                new Book("Eleonora Kalkowska","Głód życia",1904),
                new Book("Zofia Urbanowska", "Księżniczka",1886),
                new Book("Eliza Orzeszkowa", "Dobra pani", 1888),
                new Book("Gabriela Zapolska", "Kaśka Kariatyda", 1895)
        );
        sce.getServletContext().setAttribute("books", books);
    }
}
