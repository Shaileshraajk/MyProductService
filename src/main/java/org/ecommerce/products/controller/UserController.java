package org.ecommerce.products.controller;

import org.ecommerce.products.model.User;
import org.ecommerce.products.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public User addUser(@RequestBody User u){
        return userService.CreateUser(u.getName(), u.getEmail());
    }

    @GetMapping("/{name}")
    public Optional<User> addUser(@PathVariable String name){
        return userService.findbyName(name);
    }
}
