package com.mjj.travelling.controller;

import com.mjj.travelling.dao.UserRepository;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //查看个人信息
    @GetMapping(value = "information")
    public User getUserByUsername(@RequestParam("username") String username) {
        return userService.getUserInfo(username);
    }

    @PostMapping(value = "information/add")
    public User addUser(User user) {
        user.setMyLike(0);
        user.setMyFollow(0);
        user.setMyComment(0);
        user.setMyFavorite(0);
        return userService.save(user);
    }


    //修改个人信息
    @PostMapping(value = "information/edit")
    public User updateUserInfo(User user) {
        User origin = userService.getUserInfo(user.getUsername());
        user.setId(origin.getId());
        return userService.save(user);
    }

}
