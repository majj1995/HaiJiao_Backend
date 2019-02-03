package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.TeamPostRepository;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.TeamPost;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.TeamPostService;
import com.mjj.travelling.service.VO.TeamPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPostServiceImpl implements TeamPostService {

    @Autowired
    private TeamPostRepository teamPostRepository;

    @Autowired
    private TeamServiceImpl teamService;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public TeamPost save(TeamPost teamPost) {
        return teamPostRepository.save(teamPost);
    }

    @Override
    public void delete(Integer teamPostId) {
        teamPostRepository.deleteById(teamPostId);
    }

    @Override
    public Page<TeamPost> load(Integer page) {
        return load(page, PAGE_SIZE);
    }

    @Override
    public Page<TeamPost> load(Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<TeamPost> teamPosts = teamPostRepository.findAll(pageable);
        return teamPosts;
    }

    @Override
    public TeamPostVO loadByTeamPostId(Integer teamPostId) {
        TeamPost teamPost = teamPostRepository.findById(teamPostId).orElse(null);
        TeamPostVO teamPostVO = new TeamPostVO();
        List<User> members = teamService.loadByTeamPostId(teamPostId);
        teamPostVO.setTeamPost(teamPost);
        teamPostVO.setMembers(members);
        return teamPostVO;
    }

    @Override
    public void incLikesNum(Integer teamPostId) {
        TeamPost teamPost = teamPostRepository.findById(teamPostId).orElse(null);
        teamPost.setLikes(teamPost.getLikes() + 1);
        save(teamPost);
    }

    @Override
    public void decLikesNum(Integer teamPostId) {
        TeamPost teamPost = teamPostRepository.findById(teamPostId).orElse(null);
        teamPost.setLikes(teamPost.getLikes() - 1);
        save(teamPost);
    }
}
