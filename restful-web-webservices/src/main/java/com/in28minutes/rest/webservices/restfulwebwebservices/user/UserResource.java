package com.in28minutes.rest.webservices.restfulwebwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDaoService;
    //GET /users

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return userDaoService.findOne(id);
    }

    //POST /user

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userDaoService.save(user);
    }
}
