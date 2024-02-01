package com.example.auth.client;

import com.example.auth.dto.UserDto;
import com.example.auth.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserClient {
    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto userDto) ;
}
