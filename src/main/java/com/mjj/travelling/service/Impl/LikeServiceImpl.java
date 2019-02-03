package com.mjj.travelling.service.Impl;

import com.mjj.travelling.dao.LikeRepository;
import com.mjj.travelling.model.PostLike;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.service.LikeService;
import com.mjj.travelling.service.VO.MyLikeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostServiceImpl postService;

    private final static Integer PAGE_SIZE = 10;

    @Override
    public PostLike save(PostLike postLike) {
        userService.incMyLike(postLike.getUsername());
        postService.incLikesNum(postLike.getPostId());
        return likeRepository.save(postLike);
    }

    @Override
    public void delete(String username, Integer postId) {
        PostLike postLike = new PostLike();
        postLike.setUsername(username);
        postLike.setPostId(postId);
        userService.decMyLike(username);
        postService.decLikesNum(postId);
        likeRepository.delete(postLike);
    }

    @Override
    public MyLikeVO loadByUsername(String username, Integer page) {
        return loadByUsername(username, page, PAGE_SIZE);
    }

    @Override
    public MyLikeVO loadByUsername(String username, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null || size == 0) {
            size = PAGE_SIZE;
        }
        PageRequest pageable = PageRequest.of(page, size);
        Page<PostLike> likes = likeRepository.getByUsername(username, pageable);
        List<Post> myLikePosts = new ArrayList<>();
        for (PostLike like : likes) {
            myLikePosts.add(postService.getOne(like.getPostId()));
        }
        MyLikeVO myLikeVO = new MyLikeVO();
        myLikeVO.setLikePosts(myLikePosts);
        myLikeVO.setLikes(likes);
        return myLikeVO;
    }
}
