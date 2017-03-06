package servlets;

import storage.DatabaseStorage;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitDbServletContextListener implements ServletContextListener {
    private DatabaseStorage storage;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        storage = new DatabaseStorage();
        context.setAttribute("db", storage);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        storage = null;
    }
}