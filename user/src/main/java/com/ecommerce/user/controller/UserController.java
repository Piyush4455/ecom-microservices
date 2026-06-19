package com.ecommerce.user.controller;

import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

//    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.fetchAllUsers());
//        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        log.info("Request received for user: {}", id);

        log.trace("This is TRACE level - Very Detailed logs");
        log.debug("This is DEBUG level - Used for development debugging");
        log.info("This is INFO level - General System Information");
        log.warn("This is WARN level - Something might be wrong");
        log.error("This is ERROR level - Something failed");

        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return ResponseEntity.ok("User Added Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserRequest updatedUserRequest) {
        boolean updated = userService.updateUser(id, updatedUserRequest);
        return updated?ResponseEntity.ok("User updated Successfully"):ResponseEntity.notFound().build();
    }

}
