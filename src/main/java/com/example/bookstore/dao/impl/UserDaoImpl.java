package com.example.bookstore.dao.impl;

import com.example.bookstore.dao.UserTemporaryDao;
import com.example.bookstore.util.DbConnection;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class UserDaoImpl implements UserTemporaryDao {

    @Override
    public boolean loginUser(String email, String hasedPassword) {
        try {
            String sql = "SELECT *FROM tbl_user WHERE email=? AND password=?";
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, hasedPassword);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
