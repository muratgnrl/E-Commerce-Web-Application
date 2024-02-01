package com.example.auth.dto;


import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Log4j2
@Data
@Getter
@Setter
public class UserDto implements Serializable {

    public long id;

    public String lastName;

    public String firstName;

    public String password;

    public String mail;


}
