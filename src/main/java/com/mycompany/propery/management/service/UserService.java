package com.mycompany.propery.management.service;

import com.mycompany.propery.management.model.User;

public interface UserService {

    public User register(User user);

    public User login(String userEmail, String password);

}
