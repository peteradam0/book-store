package com.example.bookstore.service.Impl;

import com.example.bookstore.dao.UserDao;
import com.example.bookstore.dao.UserTemporaryDao;
import com.example.bookstore.entity.User;
import com.example.bookstore.exception.ServiceLayerException;
import com.example.bookstore.service.UserService;
import com.example.bookstore.util.PasswordEncrypterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTemporaryDao userTemporaryDao;

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public void insertUser(User user) throws ServiceLayerException {
        if (userExists(user)) {
            logger.severe("User already exists");
            throw new ServiceLayerException("User already exists");
        } else {
            userDao.save(user);
        }
    }

    @Override
    public boolean userExists(User user) {
        User userFromDb = userDao.getUserByEmail(user.getEmail());
        return userFromDb != null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) throws ServiceLayerException {
        Optional<User> user = Optional.of(userDao.getUserByEmail(email));
        if (user.isEmpty()) {
            logger.severe("User with email: " + email + " not found");
            throw new ServiceLayerException("User not found");
        }
        return user;
    }

    @Override
    public boolean loginUser(String email, String password) {
        return userTemporaryDao.loginUser(email,password);
    }


    private User encryptUserPassword(User user) {
        String encryptedPassword = PasswordEncrypterUtil.passwordHash(user.getPassword());
        user.setPassword(encryptedPassword);
        return user;
    }


}
