package com.mycompany.propery.management.repository;

import com.mycompany.propery.management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
