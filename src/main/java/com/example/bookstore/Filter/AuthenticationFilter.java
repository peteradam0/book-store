package com.example.bookstore.Filter;

import com.example.bookstore.entity.User;
import com.example.bookstore.exception.InvalidTokenException;
import com.example.bookstore.exception.ServiceLayerException;
import com.example.bookstore.service.UserService;
import com.example.bookstore.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@Order(0)
public class AuthenticationFilter extends OncePerRequestFilter {

    @Value("#{'${list.endpoints}'.split(',')}")
    private List<String> endpointsList;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = request.getHeader("access-token");
            String emailFromToken = jwtTokenUtil.getEmailFromToken(token);
            Optional<User> userEmailFromDb = userService.getUserByEmail(emailFromToken);
            if (!jwtTokenUtil.validateToken(token, userEmailFromDb.get().getEmail())) {
                throw new InvalidTokenException("invalid token");
            } else {
                LOGGER.info("successful");
            }
            filterChain.doFilter(request, response);
        } catch (Exception | ServiceLayerException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            LOGGER.info(e.getMessage());
        }
    }
}
