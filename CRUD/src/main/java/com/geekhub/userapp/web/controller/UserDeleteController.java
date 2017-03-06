package com.geekhub.userapp.web.controller;

import com.geekhub.userapp.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class UserDeleteController extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userRepository.delete(userId);

        request.getRequestDispatcher("/users").forward(request, response);
    }
}
