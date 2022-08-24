package ru.kata.spring.boot_security.demo.servicies;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface AdminService {

    void addUser(User user);

    List<User> showUsers();

    void deleteUserById(Long id);

    User getUserById(Long id);

    void updateUser(User userToUpdate);

}
