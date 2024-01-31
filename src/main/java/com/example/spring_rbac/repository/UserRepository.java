package com.example.spring_rbac.repository;

import com.example.spring_rbac.dao.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDao,String> {
    Optional<UserDao> findByUserName(String userName);
    Boolean existsByUserName(String userName);
}
