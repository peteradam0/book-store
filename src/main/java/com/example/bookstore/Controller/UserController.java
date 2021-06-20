package com.example.bookstore.Controller;


import com.example.bookstore.Dto.UserDto;
import com.example.bookstore.Dto.UserLoginDto;
import com.example.bookstore.Exception.FacadeLayerException;
import com.example.bookstore.Exception.ServiceLayerException;
import com.example.bookstore.Facade.Impl.UserFacadeImpl;
import com.example.bookstore.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class UserController {

    @Autowired
    private UserFacadeImpl userFacade;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/api/v1/register")
    public ResponseEntity register(@RequestBody UserDto userDto, HttpServletResponse httpServletResponse) {
        try {
            userFacade.insertUser(userDto);
            String token = jwtTokenUtil.generateToken(userDto.getEmail());
            Cookie cookie = new Cookie("access_token", token);
            httpServletResponse.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("User Registered");
        } catch (ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration fail");
        }
    }

    @PostMapping("/api/v1/login")
    public ResponseEntity login(@RequestBody UserLoginDto userDto, HttpServletResponse httpServletResponse) {
        try {
            userFacade.login(userDto);
            String token = jwtTokenUtil.generateToken(userDto.getEmail());
            Cookie cookie = new Cookie("access_token", token);
            httpServletResponse.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        } catch (FacadeLayerException | ServiceLayerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
