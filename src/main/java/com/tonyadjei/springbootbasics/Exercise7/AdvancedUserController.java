package com.tonyadjei.springbootbasics.Exercise7;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("users")
public class AdvancedUserController {
    ArrayList<User> users = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if (user.getName().isEmpty() || user.getEmail().isEmpty()){
            return ResponseEntity.status(400).body(null);
        }
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        for (User user_: users) {
            if (user_.getId() == id) {
                user_.setName(user.getName());
                user_.setEmail(user.getEmail());
                return ResponseEntity.ok(user_);
            }
        }
        if (user.getName().isEmpty() || user.getEmail().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        for (User user: users) {
            if (user.getId() == id) {
                users.remove(user);
                return ResponseEntity.status(HttpStatus.OK).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
