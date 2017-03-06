package com.geekhub.repository;

import com.geekhub.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User find(int id);

    int save(User user);

    void delete(int id);
}
