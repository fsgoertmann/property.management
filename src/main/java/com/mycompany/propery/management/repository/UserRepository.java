package com.mycompany.propery.management.repository;

import com.mycompany.propery.management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserEmailAndPassword(String userEmail, String password);
    Optional<UserEntity> findByUserEmail(String userEmail);
}
