package com.example.bookstore.converter.Impl;

import com.example.bookstore.converter.Populator;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoPopulator implements Populator<User, UserDto> {
    @Override
    public void populate(User source, UserDto target) {
        target.setId(source.getId());
        target.setUserName(source.getUserName());
        target.setEmail(source.getEmail());
        target.setPassword(source.getEmail());
    }
}
