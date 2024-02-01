package com.example.auth.controller;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.UserCreateException;
import com.example.auth.exception.DeleteUserException;
import com.example.auth.exception.UserFindException;
import com.example.auth.exception.UserLoginException;
import com.example.auth.response.UserResponse;
import com.example.auth.service.ımpl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }


    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto userDto) throws UserCreateException {
        return ResponseEntity.ok(service.createUser(userDto));
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserDto userDto) throws UserLoginException {
        return ResponseEntity.ok(service.login(userDto));
    }
    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserResponse> find(@PathVariable (value = "id") long id) throws UserFindException {
        return ResponseEntity.ok(service.find(id));
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable(value = "id") long id) throws DeleteUserException {
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/getAllUser")
    public List<UserDto> getAllUser(){
        List<UserDto> userDtoList=service.getAllUser();
        return userDtoList;
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") long id,@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.updateUser(id,userDto));
    }
}
