package com.example.bookstore.Facade.Impl;

import com.example.bookstore.Converter.Impl.UserDtoToUserPopulator;
import com.example.bookstore.Converter.Impl.UserToUserDtoPopulator;
import com.example.bookstore.Dto.UserDto;
import com.example.bookstore.Dto.UserLoginDto;
import com.example.bookstore.Entity.User;
import com.example.bookstore.Exception.FacadeLayerException;
import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Facade.UserFacade;
import com.example.bookstore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserToUserDtoPopulator userToUserDtoPopulator;

    @Autowired
    private UserDtoToUserPopulator userDtoToUserPopulator;

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userService.getAllUser();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userToUserDtoPopulator.populate(user, userDto);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userService.getUserById(id);
        UserDto userDto = new UserDto();
        userToUserDtoPopulator.populate(user, userDto);
        return userDto;
    }

    @Override
    public UserDto insertUser(UserDto userDto) throws ServiceLayerException {
        User user = new User();
        userDtoToUserPopulator.populate(userDto, user);
        System.out.println(userDto.getEmail());
        userService.insertUser(user);
        return userDto;
    }

    @Override
    public UserLoginDto login(UserLoginDto userDto) throws FacadeLayerException, ServiceLayerException {
        if(userService.getUserByEmail(userDto.getEmail()).isPresent()){
            return userDto;
        }else {
            throw new FacadeLayerException("User login faild");
        }

    }


}
