package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.FollowRepository;
import com.mjj.travelling.model.Follow;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserService userService;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public Follow save(String username, String followedUsername) {
        Follow follow = new Follow();
        follow.setUsername(username);
        follow.setFollowedUsername(followedUsername);
        userService.incMyFollow(username);
        return followRepository.save(follow);
    }

    @Override
    public void delete(String username, String followedUsername) {
        Follow follow = new Follow();
        follow.setUsername(username);
        follow.setFollowedUsername(followedUsername);
        userService.decMyFollow(username);
        followRepository.delete(follow);
    }

    @Override
    public Page<Follow> loadByUsername(String username, Integer page) {
        return loadByUsername(username, page, PAGE_SIZE);
    }

    @Override
    public Page<Follow> loadByUsername(String username, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        PageRequest pageable = PageRequest.of(page, size);
        Page<Follow> follows = followRepository.getByUsername(username, pageable);
        return follows;
    }
}
