package ru.kata.spring.boot_security.demo.servicies;


import ru.kata.spring.boot_security.demo.models.User;


import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);


}
