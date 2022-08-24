package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.servicies.AdminService;
import ru.kata.spring.boot_security.demo.servicies.RoleService;

import javax.annotation.PostConstruct;

@Component
public class TestClass {

    private final AdminService adminService;
    private final RoleService roleService;


    @Autowired
    public TestClass(AdminService adminService, RoleService roleService) {
        this.adminService = adminService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void init() {
        User admin = new User("Artem", "Kuzmin", "admin@admin", 31); // создаём Админа, логин - admin@admin
        admin.setPassword("100"); //пароль админа - "100"
        Role adminRole = new Role("ROLE_ADMIN"); // создаём роль АДМИН
        adminService.addUser(admin); // добваляем админа в базу
        roleService.addRole(adminRole); // добавляем роль в базу
        admin.addRole(adminRole); // назначем роль Админу
        adminService.updateUser(admin); // сохраняем изменения в админе

        User user1 = new User("Ivan", "Petrov", "petrov@petrov", 24); // создаём Юзера, логин - petrov@petrov
        user1.setPassword("100"); //пароль юзера - "100"
        Role userRole = new Role("ROLE_USER"); // создаём роль ЮЗЕР
        adminService.addUser(user1); // добавляем юзера в базу
        roleService.addRole(userRole); // добавляем роль в базу
        user1.addRole(userRole); // назначаем роль юзеру
        adminService.updateUser(user1); // сохраняем изменения в юзере


        User comboUser = new User("Sam", "Fisher", "fisher@fisher", 54); // создаём юзера с двумя ролями, логин - fisher@fisher
        comboUser.setPassword("100"); // пароль юзера - "100"
        adminService.addUser(comboUser); // добавляем юзера в базу
        comboUser.addRole(adminRole); // назначем роль админа
        comboUser.addRole(userRole); // назначем роль юзера
        adminService.updateUser(comboUser); // сохраняем изменения в юзере



    }

}
