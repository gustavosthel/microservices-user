package com.ms.user.controller;

import com.ms.user.DTO.UserDTO;
import com.ms.user.entity.User;
import com.ms.user.service.UserSevice;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserSevice userService;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDTO userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        var newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

}
