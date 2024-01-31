package com.example.spring_rbac.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("role")
@Data
public class RoleDao {
    @Id
    private String roleId;
    private String roleName;
}
