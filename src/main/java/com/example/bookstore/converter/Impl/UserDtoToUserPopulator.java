package com.example.bookstore.converter.Impl;

import com.example.bookstore.converter.Populator;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserPopulator implements Populator<UserDto, User> {
    @Override
    public void populate(UserDto source, User target) {
        target.setUserName(source.getUserName());
        target.setEmail(source.getEmail());
        target.setPassword(source.getEmail());
        target.setAddress(source.getAddress());
    }
}
