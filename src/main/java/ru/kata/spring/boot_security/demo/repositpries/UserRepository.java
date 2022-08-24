package ru.kata.spring.boot_security.demo.repositpries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u join fetch u.roles where u.email=?1")
    Optional<User> findByEmail(String email);
}
