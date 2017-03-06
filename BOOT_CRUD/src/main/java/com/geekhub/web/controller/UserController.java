package com.geekhub.web.controller;

import com.geekhub.model.User;
import com.geekhub.repository.UserRepository;
import com.geekhub.web.pagination.Page;
import com.geekhub.web.pagination.PageRequest;
import com.geekhub.web.pagination.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final static int USERS_PER_PAGE = 6;
    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "/show";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(@RequestParam(value = "page", defaultValue = "1") int count, Model model) {
        List<User> users = repository.findAll();
        PageRequest pageRequest = new PageRequest(count, USERS_PER_PAGE);
        Page<User> page = PaginationUtils.getPage(users, pageRequest);
        model.addAttribute("page", page);
        return "users";
    }

    @RequestMapping("users/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", repository.find(id));
        return "show";
    }

    @RequestMapping("users/edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("user", repository.find(id));
        return "update";
    }

    @RequestMapping(value = "users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "update";
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String saveUser(User user) {
        repository.save(user);
        return "redirect:/users/" + user.getId();
    }

    @RequestMapping("users/delete/{id}")
    public String delete(@PathVariable Integer id) {
        repository.delete(id);
        return "redirect:/users";
    }
}
