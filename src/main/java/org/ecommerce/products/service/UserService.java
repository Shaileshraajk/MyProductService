package org.ecommerce.products.service;

import org.ecommerce.products.model.User;

import java.util.Optional;

public interface UserService {

    public User CreateUser(String name, String email);

    public Optional<User> findbyName(String name);
}
