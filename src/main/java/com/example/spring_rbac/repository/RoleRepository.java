package com.example.spring_rbac.repository;

import com.example.spring_rbac.dao.RoleDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends MongoRepository<RoleDao,String> {
    RoleDao findByRoleName(String roleName);
}
