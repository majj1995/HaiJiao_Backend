package com.mjj.travelling.controller;

import com.mjj.travelling.model.Follow;
import com.mjj.travelling.model.User;
import com.mjj.travelling.service.Impl.*;
import com.mjj.travelling.service.VO.MyFavoriteVO;
import com.mjj.travelling.service.VO.MyLikeVO;
import com.mjj.travelling.service.VO.MyReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/personal")
public class PersonalController {

    @Autowired
    private UserService userService;

    @Autowired
    private FollowServiceImpl followService;

    @Autowired
    private LikeServiceImpl likeService;

    @Autowired
    private FavoriteServiceImpl favoriteService;

    @Autowired
    private ReplyServiceImpl replyService;

    //查看个人主页
    @GetMapping(value = "index")
    private User getUserInfo(@RequestParam("username") String username) {
        return userService.getUserInfo(username);
    }

    @GetMapping(value = "follow")
    private Page<Follow> getMyFollowedUsername(@RequestParam("username") String username, @RequestParam("page") Integer page) {
        return followService.loadByUsername(username, page);
    }

    @GetMapping(value = "like")
    private MyLikeVO getMyLikedPost(@RequestParam("username") String username, @RequestParam("page") Integer page) {
        return likeService.loadByUsername(username, page);
    }

    @GetMapping(value = "favorite")
    private MyFavoriteVO getMyFavoritePost(@RequestParam("username") String username, @RequestParam("page") Integer page) {
        return favoriteService.loadByUsername(username, page);
    }

    @GetMapping(value = "reply")
    private MyReplyVO getMyReplies(@RequestParam("username") String username, @RequestParam("page") Integer page) {
        return replyService.loadByUsername(username, page);
    }


}
