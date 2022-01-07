package com.example.bookstore.facade;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.dto.UserLoginDto;
import com.example.bookstore.exception.FacadeLayerException;
import com.example.bookstore.exception.ServiceLayerException;

import java.util.List;

public interface UserFacade {
    List<UserDto> getAllUser();

    UserDto getUserById(Long id);

    UserDto insertUser(UserDto userDto) throws ServiceLayerException;

    UserLoginDto login(UserLoginDto userDto) throws FacadeLayerException, ServiceLayerException;

}
