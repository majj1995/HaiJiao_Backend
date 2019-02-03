package com.mjj.travelling.service;

import com.mjj.travelling.model.TeamPost;
import com.mjj.travelling.service.VO.TeamPostVO;
import org.springframework.data.domain.Page;

public interface TeamPostService {

    TeamPost save(TeamPost teamPost);

    void delete(Integer teamPostId);

    Page<TeamPost> load(Integer page);

    Page<TeamPost> load(Integer page, Integer size);

    TeamPostVO loadByTeamPostId(Integer teamPostId);

    void incLikesNum(Integer teamPostId);

    void decLikesNum(Integer teamPostId);
}
