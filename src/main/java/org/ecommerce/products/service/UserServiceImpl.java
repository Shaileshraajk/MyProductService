package org.ecommerce.products.service;

import org.ecommerce.products.model.User;
import org.ecommerce.products.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User CreateUser(String name, String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findbyName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }
}
