package com.mjj.travelling.service;

import com.mjj.travelling.model.TeamFavorite;
import org.springframework.data.domain.Page;

public interface TeamFavoriteService {

    TeamFavorite save(TeamFavorite teamFavorite);

    void delete(String username, Integer teamPostId);

    Page<TeamFavorite> loadByUsername(String username, Integer page, Integer size);
}
