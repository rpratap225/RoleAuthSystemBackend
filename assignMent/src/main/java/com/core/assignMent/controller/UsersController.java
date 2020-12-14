package com.core.assignMent.controller;

import com.core.assignMent.dto.ResponseJson;
import com.core.assignMent.dto.UsersJson;
import com.core.assignMent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<UsersJson> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/update")
    public ResponseJson updateUser(@RequestBody UsersJson usersJson) {
        return userService.updateUser(usersJson);
    }

    @PostMapping(value = "/add")
    public ResponseJson addUser(@RequestBody UsersJson usersJson) {
        return userService.addUser(usersJson);
    }

}
