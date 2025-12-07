package com.wipro.WiproSpringboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// REST endpoints for user management
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users  -> returns list of users
    @GetMapping("/users")
    public List<Map<String, Object>> getUsers() {
        return userService.getAllUsers();
    }

    // POST /api/user  -> add a user (JSON body)
    @PostMapping("/user")
    public String addUser(@RequestBody User obj) {
        userService.addUser(obj);
        return "User added!";
    }

    // GET /api/users/{id}
    @GetMapping("/users/{id}")
    public Map<String, Object> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
