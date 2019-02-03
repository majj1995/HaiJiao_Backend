package com.mjj.travelling.dao;

import com.mjj.travelling.model.TeamFavorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamFavoriteRepository extends JpaRepository<TeamFavorite, String> {

    Page<TeamFavorite> getByUsername(String username, Pageable pageable);

    void deleteByUsernameAndTeamPostId(String username, Integer teamPostId);

}
