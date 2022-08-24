package ru.kata.spring.boot_security.demo.servicies;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findByRoleName(String roleName);

    void addRole(Role role);

}
