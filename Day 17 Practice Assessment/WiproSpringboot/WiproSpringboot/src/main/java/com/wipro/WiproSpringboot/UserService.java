package com.wipro.WiproSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all users (returns list of rows as maps)
    public List<Map<String, Object>> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql);
    }

    // Add a user
    public int addUser(User obj) {
        // Using parameterized update to avoid SQL injection
        String sql = "INSERT INTO users(name, password, eid, salary) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, obj.getName(), obj.getPassword(), obj.getEid(), obj.getSalary());
    }

    // Get a user by ID (eid)
    public Map<String, Object> getUserById(String id) {
        String sql = "SELECT * FROM users WHERE eid = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }
}
