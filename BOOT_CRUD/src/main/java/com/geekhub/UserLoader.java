package com.geekhub;

import com.geekhub.model.User;
import com.geekhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setFirstName("firstName" + i);
            user.setLastName("lastName" + i);
            user.setAge(i);
            repository.save(user);
        }
    }
}
