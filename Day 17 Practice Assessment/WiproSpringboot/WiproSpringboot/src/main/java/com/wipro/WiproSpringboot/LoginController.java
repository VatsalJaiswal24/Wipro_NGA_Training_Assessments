package com.wipro.WiproSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcobj;

    // Example: create a test user (POST) - safer than GET
    @PostMapping("/create-test-user")
    public String createTestUser() {
        String sql = "INSERT INTO users(name, password, eid, salary) VALUES (?, ?, ?, ?)";
        jdbcobj.update(sql, "javatpoint", "java@javatpoint.com", "E100", 1000);
        return "test user created";
    }
}
