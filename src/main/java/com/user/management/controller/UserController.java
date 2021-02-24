package com.user.management.controller;

import com.user.management.exception.UserNotFoundException;
import com.user.management.model.User;
import com.user.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.list();
    }
    //Get
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) throws UserNotFoundException {
        User user = userService.get(id).get();
        if(user == null){
            throw new UserNotFoundException("User id= " + id + " Not found");
        }
        return user;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User userSaved = userService.save(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User userSaved = userService.save(user);
        return user;
    }

    /*---Delete a User by id---*/
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }

}
