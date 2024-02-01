package com.example.auth.service;

import com.example.auth.dto.UserDto;
import com.example.auth.exception.DeleteUserException;
import com.example.auth.exception.UserCreateException;
import com.example.auth.exception.UserFindException;
import com.example.auth.exception.UserLoginException;
import com.example.auth.response.UserResponse;

import java.util.List;

public interface UserService {

    public UserResponse createUser(UserDto userDto) throws UserCreateException;

    public UserResponse login(UserDto userDto) throws UserLoginException;

    public UserResponse find(long id) throws UserFindException;

    public UserResponse delete(long id) throws DeleteUserException;

    public List<UserDto> getAllUser();

    public UserDto updateUser(long id, UserDto userDto);
    ;
}
