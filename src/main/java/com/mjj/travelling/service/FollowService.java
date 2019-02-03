package com.mjj.travelling.service;

import com.mjj.travelling.model.Follow;
import org.springframework.data.domain.Page;

public interface FollowService {

    Follow save(String username, String followedUsername);

    void delete(String username, String followedUsername);

    Page<Follow> loadByUsername(String username, Integer page);

    Page<Follow> loadByUsername(String username, Integer page, Integer size);
}
