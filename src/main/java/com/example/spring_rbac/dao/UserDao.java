package com.example.spring_rbac.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("user")
@Data
public class UserDao {
    @Id
    private String userId;
    private String userName;
    private String password;
    @DBRef
    private List<RoleDao> role;
}
