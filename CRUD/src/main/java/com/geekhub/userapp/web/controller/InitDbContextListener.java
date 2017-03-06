package com.geekhub.userapp.web.controller;

import com.geekhub.userapp.repository.UserRepository;
import com.geekhub.userapp.repository.UserRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitDbContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        UserRepository userRepository = new UserRepositoryImpl();
        servletContext.setAttribute("userRepository", userRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
