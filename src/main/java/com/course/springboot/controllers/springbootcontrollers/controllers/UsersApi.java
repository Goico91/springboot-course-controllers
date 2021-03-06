package com.course.springboot.controllers.springbootcontrollers.controllers;

import com.course.springboot.controllers.springbootcontrollers.vo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API for Users Services
 */
@RequestMapping(value = "/users")
public interface UsersApi {

    /**
     * Get Users
     *
     * @param name of the users to filter
     * @return list of users
     */
    @GetMapping
    List<User> getUsers(@RequestParam(required = false) String name);

    /**
     * Get User By Id
     *
     * @param id to filter
     * @return User with that id
     */
    @GetMapping("/{id}")
    User getUser(@PathVariable int id);

    /**
     * Create User
     * @param user to create
     */
    @PostMapping
    void createUser(@RequestBody User user);

    /**
     * Update User
     * @param user to update
     */
    @PutMapping
    void updateUser(@RequestBody User user);

    /**
     * Delete User
     * @param id from the user to delete
     */
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable int id);
}
