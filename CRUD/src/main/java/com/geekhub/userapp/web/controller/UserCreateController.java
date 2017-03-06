package com.geekhub.userapp.web.controller;

import com.geekhub.userapp.model.User;
import com.geekhub.userapp.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createUser")
public class UserCreateController extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        User user = new User(firstName, lastName, age);
        userRepository.save(user);

        response.sendRedirect("/users");
    }
}