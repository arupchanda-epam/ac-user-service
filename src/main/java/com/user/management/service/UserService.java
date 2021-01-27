package com.user.management.service;

import com.user.management.model.User;
import com.user.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        return (User) userRepository.save(user);
    }


    public Optional<User> get(long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
