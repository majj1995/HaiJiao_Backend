package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.UserRepository;
import com.mjj.travelling.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserInfo(String username) {
        return userRepository.getByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User incMyLike(String username) {
        User user = getUserInfo(username);
        user.setMyLike(user.getMyLike() + 1);
        return save(user);
    }

    public User decMyLike(String username) {
        User user = getUserInfo(username);
        user.setMyLike(user.getMyLike() - 1);
        return save(user);
    }

    public User incMyFavorite(String username) {
        User user = getUserInfo(username);
        user.setMyFavorite(user.getMyFavorite() + 1);
        return save(user);
    }

    public User decMyFavorite(String username) {
        User user = getUserInfo(username);
        user.setMyFavorite(user.getMyFavorite() - 1);
        return save(user);
    }

    public User incMyComment(String username) {
        User user = getUserInfo(username);
        user.setMyComment(user.getMyComment() + 1);
        return save(user);
    }

    public User decMycomment(String username) {
        User user = getUserInfo(username);
        user.setMyComment(user.getMyComment() - 1);
        return save(user);
    }

    public User incMyFollow(String username) {
        User user = getUserInfo(username);
        user.setMyFollow(user.getMyFollow());
        return save(user);
    }

    public User decMyFollow(String username) {
        User user = getUserInfo(username);
        user.setMyFollow(user.getMyFollow() - 1);
        return save(user);
    }


}
