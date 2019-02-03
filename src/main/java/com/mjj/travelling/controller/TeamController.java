package com.mjj.travelling.controller;

import com.mjj.travelling.model.Team;
import com.mjj.travelling.model.TeamPost;
import com.mjj.travelling.service.Impl.TeamPostServiceImpl;
import com.mjj.travelling.service.Impl.TeamServiceImpl;
import com.mjj.travelling.service.VO.TeamPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "/team")
public class TeamController {

    @Autowired
    private TeamPostServiceImpl teamPostService;

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping(value = "index")
    public Page<TeamPost> getTeamPosts(@RequestParam("page") Integer page) {
        return teamPostService.load(page);
    }

    //第一次迭代，组队帖子还没有评论
    @GetMapping(value = "detail")
    public TeamPostVO getOne(@RequestParam("postId") Integer postId) {
        return teamPostService.loadByTeamPostId(postId);
    }

    @PostMapping(value = "post")
    public TeamPost addTeamPost(TeamPost teamPost) {
        teamPost.setPostTime(new Timestamp(new Date().getTime()));
        teamPost.setLikes(0);
        teamPost.setComments(0);
        return teamPostService.save(teamPost);
    }

    //暂时组队帖子点赞无法在个人界面里面查看
    @PutMapping(value = "detail/addLike")
    public void addLike(@RequestParam("postId") Integer postId) {
        teamPostService.incLikesNum(postId);
    }

    @PutMapping(value = "detail/cancelLike")
    public void cancelLike(@RequestParam("postId") Integer postId) {
        teamPostService.decLikesNum(postId);
    }

    //TODO 收藏

    @PutMapping(value = "detail/addMember")
    public Team addMember(@RequestParam("teamPostId") Integer teamPostId, @RequestParam("username") String username) {
        //TODO 判断团队是否满员
        return teamService.save(username, teamPostId);
    }

    //TODO 删除成员


}
