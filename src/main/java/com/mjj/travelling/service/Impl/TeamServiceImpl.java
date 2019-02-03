package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.TeamRepository;
import com.mjj.travelling.model.Team;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    @Override
    public Team save(String username, Integer teamPostId) {
        Team team = new Team();
        team.setUsername(username);
        team.setTeamPostId(teamPostId);
        return teamRepository.save(team);
    }

    @Override
    public void delete(String username, Integer teamPostId) {
        teamRepository.deleteByUsernameAndTeamPostId(username, teamPostId);
    }

    @Override
    public List<User> loadByTeamPostId(Integer teamPostId) {
        List<User> users = new ArrayList<>();
        List<Team> teams = teamRepository.getByTeamPostId(teamPostId);
        for (Team team : teams) {
            users.add(userService.getUserInfo(team.getUsername()));
        }
        return users;
    }
}
