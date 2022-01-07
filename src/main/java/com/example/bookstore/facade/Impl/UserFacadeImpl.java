package com.example.bookstore.facade.Impl;

import com.example.bookstore.converter.Impl.UserDtoToUserPopulator;
import com.example.bookstore.converter.Impl.UserToUserDtoPopulator;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.dto.UserLoginDto;
import com.example.bookstore.entity.User;
import com.example.bookstore.exception.FacadeLayerException;
import com.example.bookstore.exception.ServiceLayerException;
import com.example.bookstore.facade.UserFacade;
import com.example.bookstore.service.UserService;
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
        if(userService.loginUser(userDto.getEmail(),userDto.getPassword())){
            return userDto;
        }else {
            throw new FacadeLayerException("User login faild");
        }

    }


}
