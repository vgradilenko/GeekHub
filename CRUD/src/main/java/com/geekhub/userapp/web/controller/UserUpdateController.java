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

@WebServlet("/updateUser")
public class UserUpdateController extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        User updateUser = userRepository.find(id);

        updateUser.setFirstName(firstName);
        updateUser.setLastName(lastName);
        updateUser.setAge(age);
        userRepository.save(updateUser);

        request.getRequestDispatcher("/users").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userRepository.find(userId);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/view/user/update.jsp").forward(request, response);
    }
}
