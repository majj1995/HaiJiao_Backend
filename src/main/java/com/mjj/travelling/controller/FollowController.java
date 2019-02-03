package com.mjj.travelling.controller;

import com.mjj.travelling.model.Follow;
import com.mjj.travelling.service.Impl.FollowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {

    @Autowired
    private FollowServiceImpl followService;

    @PutMapping(value = "addfollow")
    public Follow addFollow(@RequestParam("username") String username, @RequestParam("followedusername") String followedUsername) {
        return followService.save(username, followedUsername);
    }

    @PutMapping(value = "cancelfollow")
    public void cancelFollow(@RequestParam("username") String username, @RequestParam("followusername") String followedUsername) {
        followService.delete(username, followedUsername);
    }
}
