package com.mycompany.propery.management.service.impl;

import com.mycompany.propery.management.converter.UserConverter;
import com.mycompany.propery.management.entity.UserEntity;
import com.mycompany.propery.management.exception.BusinessException;
import com.mycompany.propery.management.exception.ErrorModel;
import com.mycompany.propery.management.model.User;
import com.mycompany.propery.management.repository.UserRepository;
import com.mycompany.propery.management.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    UserConverter userConverter;

    public UserServiceImpl(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        Optional<UserEntity> userEntity = userRepository.findByUserEmail(user.getUserEmail());
        if (userEntity.isEmpty()) {
            UserEntity ue = userRepository.save(userConverter.convertUserModelToEntity(user));
            return userConverter.convertUserEntityToModel(ue);
        }

        List<ErrorModel> errors = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("EMAIL ALREADY EXISTS");
        errorModel.setMessage("Email already exists");
        errors.add(errorModel);

        throw new BusinessException(errors);
    }

    @Override
    public User login(String userEmail, String password) {
        Optional<UserEntity> optUserEnt = userRepository.findByUserEmailAndPassword(userEmail, password);
        if (optUserEnt.isPresent()) {
            return  userConverter.convertUserEntityToModel(optUserEnt.get());
        }
        List<ErrorModel> errors = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("INVALID LOGIN");
        errorModel.setMessage("Invalid user email or password");
        errors.add(errorModel);

        throw new BusinessException(errors);
    }
}
