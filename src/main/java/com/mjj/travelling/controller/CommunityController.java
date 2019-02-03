package com.mjj.travelling.controller;


import com.mjj.travelling.model.Favorite;
import com.mjj.travelling.model.PostLike;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.Reply;
import com.mjj.travelling.service.Impl.FavoriteServiceImpl;
import com.mjj.travelling.service.Impl.LikeServiceImpl;
import com.mjj.travelling.service.Impl.PostServiceImpl;
import com.mjj.travelling.service.Impl.ReplyServiceImpl;
import com.mjj.travelling.service.LikeService;
import com.mjj.travelling.service.VO.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "/community")
public class CommunityController {

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private ReplyServiceImpl replyService;

    @Autowired
    private LikeServiceImpl likeService;

    @Autowired
    private FavoriteServiceImpl favoriteService;

    //旅游贴主页浏览
    @GetMapping(value = "index")
    public Page<Post> getPosts(@RequestParam("page") Integer page) {
        return postService.load(page);
    }

    //查看具体帖子内容
    @GetMapping(value = "detail")
    public PostVO getOne(@RequestParam("postId") Integer postId, @RequestParam("replyPage") Integer replyPage) {
        return postService.loadByPostId(postId,replyPage);
    }

    //发帖
    @PostMapping(value = "post")
    public Post addPost(Post post) {
        post.setPostTime(new Timestamp(new Date().getTime()));
        post.setComments(0);
        post.setLikes(0);
        return postService.save(post);
    }

    //帖子中点赞
    @PutMapping(value = "detail/addLike")
    public PostLike addLike(@RequestParam("postId") Integer postId, @RequestParam("username") String username) {
        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUsername(username);
        return likeService.save(postLike);
    }

    //帖子中取消点赞
    @PutMapping(value = "detail/cancelLike")
    public void cancelLike(@RequestParam("postId") Integer postId, @RequestParam("username") String username) {
        likeService.delete(username, postId);
    }

    //帖子中添加评论
    @PostMapping(value = "detail/addReply")
    public Reply addReply(Reply reply) {
        reply.setReplyTime(new Timestamp(new Date().getTime()));
        reply.setLikes(0);
        reply.setComments(0);
        return replyService.save(reply);
    }

    //帖子中收藏
    @PutMapping(value = "detail/addFavorite")
    public Favorite addFavorite(@RequestParam("postId") Integer postId, @RequestParam("username") String username) {
        return favoriteService.save(username, postId);
    }

    //帖子中取消收藏
    @PutMapping(value = "detail/cancelFavorite")
    public void cancelFavorite(@RequestParam("postId") Integer postId, @RequestParam("username") String username) {
        favoriteService.delete(username, postId);
    }




}
