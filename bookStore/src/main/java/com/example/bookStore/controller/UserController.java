package com.example.bookStore.controller;

import com.example.bookStore.model.User;
import com.example.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id){
        return userService.findUser(id);
    }

    @PostMapping("/")
    @ResponseBody
    public User createUser(@RequestBody User user){
        User foundUser = userService.findUserByUsername(user.getUsername());
        if(foundUser == null){
            return userService.saveUser(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
