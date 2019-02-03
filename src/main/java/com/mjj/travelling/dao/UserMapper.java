package com.mjj.travelling.dao;

import com.mjj.travelling.model.User;

import java.util.List;

public interface UserMapper {

    public List<User> getUserByUsername(String username);

}
