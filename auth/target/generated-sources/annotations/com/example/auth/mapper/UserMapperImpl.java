package com.example.auth.mapper;

import com.example.auth.dto.UserDto;
import com.example.auth.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-31T13:35:24+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toResource(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.lastName = e.getLastName();
        userDto.firstName = e.getFirstName();
        userDto.password = e.getPassword();
        userDto.mail = e.getMail();

        return userDto;
    }

    @Override
    public User toEntity(UserDto r) {
        if ( r == null ) {
            return null;
        }

        User user = new User();

        user.setLastName( r.lastName );
        user.setFirstName( r.firstName );
        user.setPassword( r.password );
        user.setMail( r.mail );

        return user;
    }

    @Override
    public List<UserDto> toResourse(List<User> eList) {
        if ( eList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( eList.size() );
        for ( User user : eList ) {
            list.add( toResource( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntity(List<UserDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( rList.size() );
        for ( UserDto userDto : rList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }
}
