package com.example.auth.service.ımpl;


import com.example.auth.dto.UserDto;
import com.example.auth.exception.UserCreateException;
import com.example.auth.exception.DeleteUserException;
import com.example.auth.exception.UserFindException;
import com.example.auth.exception.UserLoginException;
import com.example.auth.mapper.UserMapper;
import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.response.Meta;
import com.example.auth.response.UserResponse;
import com.example.auth.service.UserService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public UserResponse createUser(UserDto userDto) throws UserCreateException {
        User user = mapper.toEntity(userDto);
        user = repository.save(user);

        if (user != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.meta = new Meta(200, "Kayıt başarılı");
            userResponse.user = mapper.toResource(user);
            return userResponse;
        } else {
            throw new UserCreateException();
        }
    }

    public UserResponse login(UserDto userDto) throws UserLoginException {
        User user = repository.findUserByMailAndPassword(userDto.mail, userDto.password);
        if (user != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.meta = new Meta(200, "Giriş başarılı");
            userResponse.user = mapper.toResource(user);
            return userResponse;
        }
        throw new UserLoginException();
    }

    public UserResponse find(long id) throws UserFindException {
        User user=findUser(id);
        if (user!=null){
            UserResponse response=new UserResponse();
            response.meta=new Meta(200,"Kullanıcı bulundu : " +id);
            response.user=mapper.toResource(user);
            return response;
        }
        throw new  UserFindException();
    }

    private User findUser(long id) {
        User user=repository.findUserById(id);
        return user;
    }

    public UserResponse delete(long id) throws DeleteUserException {
        User user=repository.findUserById(id);
        if (user !=null){
            repository.deleteById(id);
            UserResponse userResponse=new UserResponse();
            userResponse.user=mapper.toResource(user);
            userResponse.meta=new Meta(200,"Kullanıcı Sİlindi  : " + id );
            return userResponse;

        }
        throw new DeleteUserException();
    }

    public List<UserDto> getAllUser() {
        List<UserDto> userDtoList=new ArrayList<>();

        Iterable<User> users=repository.findAll();
        for (User entity : users){

            UserDto userDto=mapper.toResource(entity);
            userDtoList.add(userDto);

        }
        return userDtoList;
    }

    public UserDto updateUser(long id, UserDto userDto) {


        User entity=mapper.toEntity(userDto);
        User user=repository.findUserById(id);

        user.setLastName(entity.getLastName());
        user.setMail(entity.getMail());
        user.setLastName(entity.getLastName());
        user.setPassword(entity.getPassword());

        User updatedUser=repository.save(user);

        UserDto usertoDto=mapper.toResource(updatedUser);
        return usertoDto;

    }
}
