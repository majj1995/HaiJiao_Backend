package com.mjj.travelling.dao;

import com.mjj.travelling.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    List<Team> getByTeamPostId(Integer teamPostId);

    void deleteByUsernameAndTeamPostId(String username, Integer teamPostId);
}
