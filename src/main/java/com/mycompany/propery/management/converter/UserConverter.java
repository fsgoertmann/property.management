package com.mycompany.propery.management.converter;

import com.mycompany.propery.management.entity.UserEntity;
import com.mycompany.propery.management.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertUserModelToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setUserEmail(user.getUserEmail());
        userEntity.setPhone(user.getPhone());
        return userEntity;
    }

    public User convertUserEntityToModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setUserEmail(userEntity.getUserEmail());
        user.setPhone(userEntity.getPhone());
        return user;
    }
}
