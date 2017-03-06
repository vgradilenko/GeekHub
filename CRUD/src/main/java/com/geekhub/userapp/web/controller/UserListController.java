package com.geekhub.userapp.web.controller;

import com.geekhub.userapp.model.User;
import com.geekhub.userapp.repository.UserRepository;
import com.geekhub.userapp.web.pagination.Page;
import com.geekhub.userapp.web.pagination.PageRequest;
import com.geekhub.userapp.web.pagination.PaginationUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserListController extends HttpServlet {

    private final static int USERS_PER_PAGE = 5;

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        userRepository = (UserRepository) context.getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = userRepository.findAll();
        PageRequest pageRequest = extractPageRequest(request);
        Page<User> page = PaginationUtils.getPage(users, pageRequest);

        request.setAttribute("page", page);
        request.getRequestDispatcher("/WEB-INF/view/user/list.jsp").forward(request, response);

    }

    private PageRequest extractPageRequest(HttpServletRequest request) {
        String page = request.getParameter("page");
        if (page != null) {
            return new PageRequest(Integer.parseInt(page), USERS_PER_PAGE);
        } else {
            return new PageRequest(1, USERS_PER_PAGE);
        }
    }
}
