package com.example.auth.exception;

import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> createUserException(UserCreateException createException, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4004;
        meta.errorDescription="Kayıt başarısız";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> loginException(UserLoginException userLoginException, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4044;
        meta.errorDescription="Giriş başarısız lütfen şifrenizi veya mailinizi kontrol ediniz.";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findException(UserFindException userFindException, WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4044;
        meta.errorDescription="Kullanıcı bulunamadı Lütfen var olan bir kullanıcı giriniz";

        userResponse.meta=meta;
        ResponseEntity<Object> entity =new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteUserException(DeleteUserException deleteUserException , WebRequest webRequest){

        Meta meta=new Meta();
        UserResponse userResponse=new UserResponse();

        meta.errorCode=4011;
        meta.errorDescription="Kullanıcı bulunamadı Lütfen var olan bir kullanıcı giriniz";

        userResponse.meta=meta;
        ResponseEntity<Object> entity=new ResponseEntity<>(userResponse ,HttpStatus.NOT_FOUND);
        return entity;
    }
}
