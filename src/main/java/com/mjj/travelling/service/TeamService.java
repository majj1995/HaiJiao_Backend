package com.mjj.travelling.service;

import com.mjj.travelling.model.Team;
import com.mjj.travelling.model.User;

import java.util.List;

public interface TeamService {

    Team save(String username, Integer teamPostId);

    void delete(String username, Integer teamPostId);

    List<User> loadByTeamPostId(Integer teamPostId);
}
