package com.mycompany.propery.management.service.impl;

import com.mycompany.propery.management.converter.UserConverter;
import com.mycompany.propery.management.entity.UserEntity;
import com.mycompany.propery.management.model.User;
import com.mycompany.propery.management.repository.UserRepository;
import com.mycompany.propery.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public User register(User user) {
        UserEntity ue = userRepository.save(userConverter.convertUserModelToEntity(user));
        return userConverter.convertUserEntityToModel(ue);
    }

    @Override
    public User login(String userEmail, String password) {
        return null;
    }
}
