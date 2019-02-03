package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.TeamFavoriteRepository;
import com.mjj.travelling.model.TeamFavorite;
import com.mjj.travelling.service.TeamFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeamFavoriteServiceImpl implements TeamFavoriteService {

    @Autowired
    private TeamFavoriteRepository teamFavoriteRepository;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public TeamFavorite save(TeamFavorite teamFavorite) {
        return teamFavoriteRepository.save(teamFavorite);
    }

    @Override
    public void delete(String username, Integer teamPostId) {
        teamFavoriteRepository.deleteByUsernameAndTeamPostId(username, teamPostId);
    }

    @Override
    public Page<TeamFavorite> loadByUsername(String username, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<TeamFavorite> teamFavorites = teamFavoriteRepository.getByUsername(username, pageable);
        return teamFavorites;
    }
}
