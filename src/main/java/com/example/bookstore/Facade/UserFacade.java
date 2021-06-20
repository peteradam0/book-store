package com.example.bookstore.Facade;

import com.example.bookstore.Dto.UserDto;
import com.example.bookstore.Dto.UserLoginDto;
import com.example.bookstore.Exception.FacadeLayerException;
import com.example.bookstore.Exception.ServiceLayerException;

import java.util.List;

public interface UserFacade {
    List<UserDto> getAllUser();

    UserDto getUserById(Long id);

    UserDto insertUser(UserDto userDto) throws ServiceLayerException;

    UserLoginDto login(UserLoginDto userDto) throws FacadeLayerException, ServiceLayerException;

}
