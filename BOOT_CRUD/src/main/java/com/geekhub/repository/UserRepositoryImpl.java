package com.geekhub.repository;

import com.geekhub.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final AtomicInteger idGenerator = new AtomicInteger();
    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User find(int id) {
        for (User user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    @Override
    public int save(User user) {
        Integer id = user.getId();
        if (id == null) {
            id = idGenerator.incrementAndGet();
            user.setId(id);
            users.add(user);
            return id;
        } else {
            User userToUpdate = find(id);
            userToUpdate.setAge(user.getAge());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            users.remove(user);
            users.add(userToUpdate);
            return userToUpdate.getId();
        }
    }

    @Override
    public void delete(int id) {
        User userToDelete = null;
        for (User user : users) {
            if (id == user.getId()) {
                userToDelete = user;
                break;
            }
        }
        users.remove(userToDelete);
    }
}
